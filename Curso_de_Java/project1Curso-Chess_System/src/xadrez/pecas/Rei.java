
package xadrez.pecas;

import jogodetabuleiro.Posicao;
import jogodetabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

public class Rei extends PecaDeXadrez{
    
    public Rei(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }
    
    //----------------------------------------------------------------------------------------------------------------//

    private boolean podeMover(Posicao posicao){
        PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(posicao);
        
        return (p == null || p.getCor() != getCor());
    }
    
    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        
        Posicao p = new Posicao(0, 0);
        
        //Cima
        p.setValores(posicao.getLinha() - 1, posicao.getColuna());
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //Cima Esquerda
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //Esquerda
        p.setValores(posicao.getLinha(), posicao.getColuna() - 1);
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //Baixo Esquerda
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //Baixo
        p.setValores(posicao.getLinha() + 1, posicao.getColuna());
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //Baixo Direita
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //Direita
        p.setValores(posicao.getLinha(), posicao.getColuna() + 1);
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //Cima Direita
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        
        return mat;
    }
}
