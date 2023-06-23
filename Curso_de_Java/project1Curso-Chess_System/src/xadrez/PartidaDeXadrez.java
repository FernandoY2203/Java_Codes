
package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import jogodetabuleiro.Peca;
import jogodetabuleiro.Posicao;
import jogodetabuleiro.Tabuleiro;
import xadrez.pecas.Bispo;
import xadrez.pecas.Cavalo;
import xadrez.pecas.Dama;
import xadrez.pecas.Peao;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {
    private Integer turno;
    private Cor jogadorAtual;
    private boolean xeque;
    private boolean xequeMate;
    private PecaDeXadrez enPassantVulneravel;
    private PecaDeXadrez promoted;
    
    private final Tabuleiro tbl;
    
    private final List<Peca> pecasNoTabuleiro = new ArrayList<>();
    private final List<Peca> pecasCapturadas = new ArrayList<>();
    
    //----------------------------------------------------------------------------------------------------------------//

    public PartidaDeXadrez() {
        tbl = new Tabuleiro(8,8);
        turno = 1;
        jogadorAtual = Cor.WHITE;
        
        setupInicial();
    }
    
    //----------------------------------------------------------------------------------------------------------------//

    public Integer getTurno() {
        return turno;
    }

    public Cor getJogadorAtual() {
        return jogadorAtual;
    }

    public boolean getXeque() {
        return xeque;
    }

    public boolean getXequeMate() {
        return xequeMate;
    }  

    public PecaDeXadrez getEnPassantVulneravel() {
        return enPassantVulneravel;
    }

    public PecaDeXadrez getPromoted() {
        return promoted;
    }
    
    //----------------------------------------------------------------------------------------------------------------//
    
    public PecaDeXadrez[][] getPecas(){
        PecaDeXadrez[][] mat = new PecaDeXadrez[tbl.getLinhas()][tbl.getColunas()];
        
        for (int i = 0; i < tbl.getLinhas(); i++) {
            for (int j = 0; j < tbl.getColunas(); j++) {
                mat[i][j] = (PecaDeXadrez) tbl.peca(i,j);
            }
        }
        
        return mat;
    }
    
    public boolean[][] movimentosPossiveis(PosicaoNoXadrez posicaoDeOrigem){
        Posicao p = posicaoDeOrigem.paraPosicao();
        
        validarPosicaoDeOrigem(p);
        
        return tbl.peca(p).movimentosPossiveis();
    }
    
    public PecaDeXadrez executarOMovimentoDeXadrez(PosicaoNoXadrez posicaoDeOrigem, PosicaoNoXadrez posicaoAlvo){
        Posicao origem = posicaoDeOrigem.paraPosicao();
        Posicao alvo = posicaoAlvo.paraPosicao();
        
        validarPosicaoDeOrigem(origem);
        validarPosicaoAlvo(origem, alvo);
        Peca pecaCapturada = fazerMovimento(origem, alvo);
        
        if(testeXeque(jogadorAtual)){
            desfazerMovimento(origem, alvo, pecaCapturada);
            
            throw new ExcecaoDoXadrez("Voce não pode se colocar em Xeque");
        }
        
        PecaDeXadrez pecaMovida = (PecaDeXadrez)tbl.peca(alvo);
        
        //Movimento Especial: Promoção
        promoted = null;
        
        if(pecaMovida instanceof Peao){
            if(pecaMovida.getCor() == Cor.WHITE && alvo.getLinha() == 0 || pecaMovida.getCor() == Cor.BLACK && alvo.getLinha() == 7){
                promoted = (PecaDeXadrez)tbl.peca(alvo);
                promoted = trocarPecaPromovida("D");
            }
        }
        
        xeque = testeXeque(oponente(jogadorAtual));
        
        if(testeXequeMate(oponente(jogadorAtual))){
            xequeMate = true;
        }
        else{
            proximoTurno();
        }
        
        
        //Movimento Especial: En Passant
        if(pecaMovida instanceof Peao && (alvo.getLinha() == origem.getLinha() - 2 || alvo.getLinha() == origem.getLinha() + 2)){
            enPassantVulneravel = pecaMovida;
        }
        else{
            enPassantVulneravel = null;
        }
            
        return (PecaDeXadrez)pecaCapturada; 
    }
    
    private Peca fazerMovimento(Posicao origem, Posicao alvo){
        Peca p = tbl.removerPeca(origem);
        Peca pecaCapturada = tbl.removerPeca(alvo);
        
        ((PecaDeXadrez)p).aumentarContadorDeMovimento();
        
        tbl.colocarPeca(p, alvo);
        
        if(pecaCapturada != null){
            pecasNoTabuleiro.remove(pecaCapturada);
            pecasCapturadas.add(pecaCapturada);
        }
        
        
        //Movimento Especial: Roque
        ///Lado do Rei
        if(p instanceof Rei && alvo.getColuna() == origem.getColuna() + 2){
            Posicao origemTorre = new Posicao(origem.getLinha(), origem.getColuna() + 3);
            Posicao alvoTorre = new Posicao(origem.getLinha(), origem.getColuna() + 1);
            
            PecaDeXadrez torre = (PecaDeXadrez)tbl.removerPeca(origemTorre);
            tbl.colocarPeca(torre, alvoTorre);
            
            torre.aumentarContadorDeMovimento();
        }
        
        ///Lado da Dama
        if(p instanceof Rei && alvo.getColuna() == origem.getColuna() - 2){
            Posicao origemTorre = new Posicao(origem.getLinha(), origem.getColuna() - 4);
            Posicao alvoTorre = new Posicao(origem.getLinha(), origem.getColuna() - 1);
            
            PecaDeXadrez torre = (PecaDeXadrez)tbl.removerPeca(origemTorre);
            tbl.colocarPeca(torre, alvoTorre);
            
            torre.aumentarContadorDeMovimento();
        }
        
        
        //Movimento Especial: En Passant
        if(p instanceof Peao){
            if(origem.getColuna() != alvo.getColuna() && pecaCapturada == null){
                Posicao posicaoDoPeao;
                
                if(((PecaDeXadrez)p).getCor() == Cor.WHITE){
                    posicaoDoPeao = new Posicao(alvo.getLinha() + 1, alvo.getColuna());
                }
                else{
                    posicaoDoPeao = new Posicao(alvo.getLinha() - 1, alvo.getColuna());
                }
                
                pecaCapturada = tbl.removerPeca(posicaoDoPeao);
                pecasCapturadas.add(pecaCapturada);
                pecasNoTabuleiro.remove(pecaCapturada);
            }
        }
        
        return pecaCapturada;
    }
    
    private void desfazerMovimento(Posicao origem, Posicao alvo, Peca pecaCapturada){
        Peca p = tbl.removerPeca(alvo);
        tbl.colocarPeca(p, origem);
        
        ((PecaDeXadrez)p).diminuirContadorDeMovimento();
        
        if(pecaCapturada != null){
            tbl.colocarPeca(pecaCapturada, alvo);
            pecasCapturadas.remove(pecaCapturada);
            pecasNoTabuleiro.add(pecaCapturada);
        }
        
        
        //Movimento Especial: Roque
        ///Lado do Rei
        if(p instanceof Rei && alvo.getColuna() == origem.getColuna() + 2){
            Posicao origemTorre = new Posicao(origem.getLinha(), origem.getColuna() + 3);
            Posicao alvoTorre = new Posicao(origem.getLinha(), origem.getColuna() + 1);
            
            PecaDeXadrez torre = (PecaDeXadrez)tbl.removerPeca(alvoTorre);
            tbl.colocarPeca(torre, origemTorre);
            
            torre.diminuirContadorDeMovimento();
        }
        
        ///Lado da Dama
        if(p instanceof Rei && alvo.getColuna() == origem.getColuna() - 2){
            Posicao origemTorre = new Posicao(origem.getLinha(), origem.getColuna() - 4);
            Posicao alvoTorre = new Posicao(origem.getLinha(), origem.getColuna() - 1);
            
            PecaDeXadrez torre = (PecaDeXadrez)tbl.removerPeca(alvoTorre);
            tbl.colocarPeca(torre, origemTorre);
            
            torre.diminuirContadorDeMovimento();
        }
        
        
        //Movimento Especial: En Passant
        if(p instanceof Peao){
            if(origem.getColuna() != alvo.getColuna() && pecaCapturada == enPassantVulneravel){
                PecaDeXadrez peao = (PecaDeXadrez)tbl.removerPeca(alvo);
                Posicao posicaoDoPeao;
                
                if(((PecaDeXadrez)p).getCor() == Cor.WHITE){
                    posicaoDoPeao = new Posicao(3, alvo.getColuna());
                }
                else{
                    posicaoDoPeao = new Posicao(4, alvo.getColuna());
                }
                
                tbl.colocarPeca(peao, posicaoDoPeao);
            }
        }
    }
    
    private void validarPosicaoDeOrigem(Posicao posicao){
        if(!tbl.temUmaPeca(posicao)){
            throw new ExcecaoDoXadrez("Não existe peça na posição de Origem");
        }
        if(jogadorAtual != ((PecaDeXadrez) tbl.peca(posicao)).getCor()){
            throw new ExcecaoDoXadrez("A peça escolhida não é sua");
        }
        if(!tbl.peca(posicao).haUmMovimentoPossivel()){
            throw new ExcecaoDoXadrez("Não existe movimentos possiveis para a peça escolida");
        }
    }
    
    private void validarPosicaoAlvo(Posicao origem, Posicao alvo){
        if(!tbl.peca(origem).movimentoPossivel(alvo)){
            throw new ExcecaoDoXadrez("A peça escolhida não pode se mover para a posição escolhida");
        }
    }
    
    private void proximoTurno(){
        turno++;
        
        jogadorAtual = (jogadorAtual == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
    }
    
    public PecaDeXadrez trocarPecaPromovida(String tipo){
        if(promoted == null){
            throw new IllegalStateException("Não há peça a ser promovida");
        }
        if(!tipo.equals("B") && !tipo.equals("C") && !tipo.equals("T") && !tipo.equals("D")){
            return promoted;
        }
        
        Posicao pos = promoted.getPosicaoNoXadrez().paraPosicao();
        Peca p = tbl.removerPeca(pos);
        pecasNoTabuleiro.remove(p);
        
        PecaDeXadrez novaPeca = novaPeca(tipo, promoted.getCor());
        tbl.colocarPeca(novaPeca, pos);
        pecasNoTabuleiro.add(novaPeca);
        
        return novaPeca;
    }
    
    private PecaDeXadrez novaPeca(String tipo, Cor cor){
        switch(tipo){
            case "B":
                return new Bispo(cor, tbl);
            case "C":
                return new Cavalo(cor, tbl);
            case "T":
                return new Torre(cor, tbl);
            default:
                return new Dama(cor, tbl);
        }
    }
    
    private Cor oponente(Cor cor){
        return (cor == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
    }
    
    private PecaDeXadrez rei(Cor cor){
        List<Peca> list = pecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez)x).getCor() == cor).collect(Collectors.toList());
        
        for(Peca p : list){
            if(p instanceof Rei){
                return (PecaDeXadrez)p;
            }
        }
        
        throw new IllegalStateException("Não há nenhum rei da cor " + cor + " no tabuleiro");
    }
    
    private boolean testeXeque(Cor cor){
        Posicao posicaoDoRei = rei(cor).getPosicaoNoXadrez().paraPosicao();
        List<Peca> pecasDoOpenente = pecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList());
        
        for (Peca p : pecasDoOpenente) {
            boolean[][] movPossiveis = p.movimentosPossiveis();
            
            if(movPossiveis[posicaoDoRei.getLinha()][posicaoDoRei.getColuna()]){
                return true;
            }
        }
        
        return false;
    }
    
    private boolean testeXequeMate(Cor cor){
        if(!testeXeque(cor)){
            return false;
        }
        
        List<Peca> list = pecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez)x).getCor() == cor).collect(Collectors.toList());
        
        for (Peca p : list) {
            boolean[][] mat = p.movimentosPossiveis();
            
            for (int i = 0; i < tbl.getLinhas(); i++) {
                for (int j = 0; j < tbl.getColunas(); j++) {
                    if(mat[i][j]){
                        Posicao origem = ((PecaDeXadrez)p).getPosicaoNoXadrez().paraPosicao();
                        Posicao alvo = new Posicao(i, j);
                        
                        Peca pecaCapturada = fazerMovimento(origem, alvo);
                        
                        boolean testeXeque = testeXeque(cor);
                        
                        desfazerMovimento(origem, alvo, pecaCapturada);
                        
                        if(!testeXeque){
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez peca){
        tbl.colocarPeca(peca, new PosicaoNoXadrez(coluna, linha).paraPosicao());
        
        pecasNoTabuleiro.add(peca);
    }    
    
    private void setupInicial(){
        //Branco
        colocarNovaPeca('a', 1, new Torre(Cor.WHITE, tbl));
        colocarNovaPeca('b', 1, new Cavalo(Cor.WHITE, tbl));
        colocarNovaPeca('c', 1, new Bispo(Cor.WHITE, tbl));
        colocarNovaPeca('d', 1, new Dama(Cor.WHITE, tbl));
        colocarNovaPeca('e', 1, new Rei(Cor.WHITE, tbl, this));
        colocarNovaPeca('f', 1, new Bispo(Cor.WHITE, tbl));
        colocarNovaPeca('g', 1, new Cavalo(Cor.WHITE, tbl));
        colocarNovaPeca('h', 1, new Torre(Cor.WHITE, tbl));
        colocarNovaPeca('a', 2, new Peao(Cor.WHITE, tbl, this));
        colocarNovaPeca('b', 2, new Peao(Cor.WHITE, tbl, this));
        colocarNovaPeca('c', 2, new Peao(Cor.WHITE, tbl, this));
        colocarNovaPeca('d', 2, new Peao(Cor.WHITE, tbl, this));
        colocarNovaPeca('e', 2, new Peao(Cor.WHITE, tbl, this));
        colocarNovaPeca('f', 2, new Peao(Cor.WHITE, tbl, this));
        colocarNovaPeca('g', 2, new Peao(Cor.WHITE, tbl, this));
        colocarNovaPeca('h', 2, new Peao(Cor.WHITE, tbl, this));

        //Preto
        colocarNovaPeca('a', 8, new Torre(Cor.BLACK, tbl));
        colocarNovaPeca('b', 8, new Cavalo(Cor.BLACK, tbl));
        colocarNovaPeca('c', 8, new Bispo(Cor.BLACK, tbl));
        colocarNovaPeca('d', 8, new Dama(Cor.BLACK, tbl));
        colocarNovaPeca('e', 8, new Rei(Cor.BLACK, tbl, this));
        colocarNovaPeca('f', 8, new Bispo(Cor.BLACK, tbl));
        colocarNovaPeca('g', 8, new Cavalo(Cor.BLACK, tbl));
        colocarNovaPeca('h', 8, new Torre(Cor.BLACK, tbl));
        colocarNovaPeca('a', 7, new Peao(Cor.BLACK, tbl, this));
        colocarNovaPeca('b', 7, new Peao(Cor.BLACK, tbl, this));
        colocarNovaPeca('c', 7, new Peao(Cor.BLACK, tbl, this));
        colocarNovaPeca('d', 7, new Peao(Cor.BLACK, tbl, this));
        colocarNovaPeca('e', 7, new Peao(Cor.BLACK, tbl, this));
        colocarNovaPeca('f', 7, new Peao(Cor.BLACK, tbl, this));
        colocarNovaPeca('g', 7, new Peao(Cor.BLACK, tbl, this));
        colocarNovaPeca('h', 7, new Peao(Cor.BLACK, tbl, this));
    }
}
