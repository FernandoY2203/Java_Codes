
package xadrez;

import jogodetabuleiro.Peca;
import jogodetabuleiro.Posicao;
import jogodetabuleiro.Tabuleiro;

public abstract class PecaDeXadrez extends Peca{
    private Cor cor;
    private Integer contadorDeMovimento = 0;
    
    //----------------------------------------------------------------------------------------------------------------//
    
    public PecaDeXadrez(Cor cor, Tabuleiro tabuleiro) {
        super(tabuleiro);
        this.cor = cor;
    }
    
    //----------------------------------------------------------------------------------------------------------------//

    public Cor getCor() {
        return cor;
    }

    public Integer getContadorDeMovimento() {
        return contadorDeMovimento;
    }
    
    //----------------------------------------------------------------------------------------------------------------//
    
    public PosicaoNoXadrez getPosicaoNoXadrez(){
        return PosicaoNoXadrez.daPosicao(posicao);
    }
    
    protected boolean haPecaDoOponente(Posicao posicao){
        PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(posicao);
        
        return (p != null && p.getCor() != cor);
    }
    
    protected void aumentarContadorDeMovimento(){
        contadorDeMovimento++;
    }
    
    protected void diminuirContadorDeMovimento(){
        contadorDeMovimento--;
    }
}
