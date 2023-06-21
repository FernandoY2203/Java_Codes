
package xadrez;

import jogodetabuleiro.Peca;
import jogodetabuleiro.Posicao;
import jogodetabuleiro.Tabuleiro;
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
        proximoTurno();
        
        return (PecaDeXadrez)pecaCapturada; 
    }
    
    private Peca fazerMovimento(Posicao origem, Posicao alvo){
        Peca p = tbl.removerPeca(origem);
        Peca pecaCapturada = tbl.removerPeca(alvo);
        
        tbl.colocarPeca(p, alvo);
        
        return pecaCapturada;
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
    
    private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez peca){
        tbl.colocarPeca(peca, new PosicaoNoXadrez(coluna, linha).paraPosicao());
    }    
    
    private void setupInicial(){
        colocarNovaPeca('c', 1, new Torre(Cor.WHITE, tbl));
        colocarNovaPeca('c', 2, new Torre(Cor.WHITE, tbl));
        colocarNovaPeca('d', 2, new Torre(Cor.WHITE, tbl));
        colocarNovaPeca('e', 2, new Torre(Cor.WHITE, tbl));
        colocarNovaPeca('e', 1, new Torre(Cor.WHITE, tbl));
        colocarNovaPeca('d', 1, new Rei(Cor.WHITE, tbl));

        colocarNovaPeca('c', 7, new Torre(Cor.BLACK, tbl));
        colocarNovaPeca('c', 8, new Torre(Cor.BLACK, tbl));
        colocarNovaPeca('d', 7, new Torre(Cor.BLACK, tbl));
        colocarNovaPeca('e', 7, new Torre(Cor.BLACK, tbl));
        colocarNovaPeca('e', 8, new Torre(Cor.BLACK, tbl));
        colocarNovaPeca('d', 8, new Rei(Cor.BLACK, tbl));
    }
}
