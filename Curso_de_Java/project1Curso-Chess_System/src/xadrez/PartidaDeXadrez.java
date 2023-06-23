
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
    
    private Tabuleiro tbl;
    
    private List<Peca> pecasNoTabuleiro = new ArrayList<>();
    private List<Peca> pecasCapturadas = new ArrayList<>();
    
    //----------------------------------------------------------------------------------------------------------------//

    public PartidaDeXadrez() {
        this.tbl = new Tabuleiro(8,8);
        this.turno = 1;
        this.jogadorAtual = Cor.WHITE;
        
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
        
        xeque = testeXeque(oponente(jogadorAtual));
        
        if(testeXequeMate(oponente(jogadorAtual))){
            xequeMate = true;
        }
        else{
            proximoTurno();
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
    
//    
//    public PecaDeXadrez trocarPecaPromovida(String tipo){
//        
//    }
    
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
        colocarNovaPeca('e', 1, new Rei(Cor.WHITE, tbl));
        colocarNovaPeca('f', 1, new Bispo(Cor.WHITE, tbl));
        colocarNovaPeca('g', 1, new Cavalo(Cor.WHITE, tbl));
        colocarNovaPeca('h', 1, new Torre(Cor.WHITE, tbl));
        colocarNovaPeca('a', 2, new Peao(Cor.WHITE, tbl));
        colocarNovaPeca('b', 2, new Peao(Cor.WHITE, tbl));
        colocarNovaPeca('c', 2, new Peao(Cor.WHITE, tbl));
        colocarNovaPeca('d', 2, new Peao(Cor.WHITE, tbl));
        colocarNovaPeca('e', 2, new Peao(Cor.WHITE, tbl));
        colocarNovaPeca('f', 2, new Peao(Cor.WHITE, tbl));
        colocarNovaPeca('g', 2, new Peao(Cor.WHITE, tbl));
        colocarNovaPeca('h', 2, new Peao(Cor.WHITE, tbl));

        //Preto
        colocarNovaPeca('a', 8, new Torre(Cor.BLACK, tbl));
        colocarNovaPeca('b', 8, new Cavalo(Cor.BLACK, tbl));
        colocarNovaPeca('c', 8, new Bispo(Cor.BLACK, tbl));
        colocarNovaPeca('d', 8, new Dama(Cor.BLACK, tbl));
        colocarNovaPeca('e', 8, new Rei(Cor.BLACK, tbl));
        colocarNovaPeca('f', 8, new Bispo(Cor.BLACK, tbl));
        colocarNovaPeca('g', 8, new Cavalo(Cor.BLACK, tbl));
        colocarNovaPeca('h', 8, new Torre(Cor.BLACK, tbl));
        colocarNovaPeca('a', 7, new Peao(Cor.BLACK, tbl));
        colocarNovaPeca('b', 7, new Peao(Cor.BLACK, tbl));
        colocarNovaPeca('c', 7, new Peao(Cor.BLACK, tbl));
        colocarNovaPeca('d', 7, new Peao(Cor.BLACK, tbl));
        colocarNovaPeca('e', 7, new Peao(Cor.BLACK, tbl));
        colocarNovaPeca('f', 7, new Peao(Cor.BLACK, tbl));
        colocarNovaPeca('g', 7, new Peao(Cor.BLACK, tbl));
        colocarNovaPeca('h', 7, new Peao(Cor.BLACK, tbl));
    }
}
