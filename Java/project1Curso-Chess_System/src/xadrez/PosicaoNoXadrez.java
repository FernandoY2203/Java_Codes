
package xadrez;

import jogodetabuleiro.Posicao;

public class PosicaoNoXadrez {
    private Character coluna;
    private Integer linha;
    
    //----------------------------------------------------------------------------------------------------------------//
    
    public PosicaoNoXadrez(Character coluna, Integer linha) {
        if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8){
            throw new ExcecaoDoXadrez("Erro instanciando posição no xadrez. Valores validos são de a1 a h8");
        }
        
        this.coluna = coluna;
        this.linha = linha;
    }
    
    //----------------------------------------------------------------------------------------------------------------//
    
    public Character getColuna() {
        return coluna;
    }

    public Integer getLinha() {
        return linha;
    }
    
    //----------------------------------------------------------------------------------------------------------------//
    
    protected Posicao paraPosicao(){
        return new Posicao(8 - linha, coluna - 'a');
    }
    
    protected static PosicaoNoXadrez daPosicao(Posicao posicao){
        return new PosicaoNoXadrez((char)('a' + posicao.getColuna()), 8 - posicao.getLinha());
    }

    @Override
    public String toString() {
        return "" + coluna + linha;
    }
}
