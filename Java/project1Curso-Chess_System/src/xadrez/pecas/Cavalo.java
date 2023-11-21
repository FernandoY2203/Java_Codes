
package xadrez.pecas;

import jogodetabuleiro.Posicao;
import jogodetabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

public class Cavalo extends PecaDeXadrez{
    
    public Cavalo(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }
    
    //----------------------------------------------------------------------------------------------------------------//
    
    private boolean podeMover(Posicao posicao){
        PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(posicao);
        
        return (p == null || p.getCor() != getCor());
    }
    
    @Override
    public String toString() {
        return "C";
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        
        Posicao p = new Posicao(0, 0);
        
        //Cima
        ///Cima Esquerda
        p.setValores(posicao.getLinha() - 2, posicao.getColuna() - 1);
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        ///Cima Direita
        p.setValores(posicao.getLinha() - 2, posicao.getColuna() + 1);
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        
        //Esquerda
        ///Esquerda Cima 
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 2);
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        ///Esquerda Baixo
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 2);
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        
        //Baixo
        ///Baixo Esquerda
        p.setValores(posicao.getLinha() + 2, posicao.getColuna() - 1);
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        ///Baixo Direita
        p.setValores(posicao.getLinha() + 2, posicao.getColuna() + 1);
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        
        //Direita
        ///Direita Cima
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 2);
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        ///Direita Baixo
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 2);
        
        if(getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        return mat;
    }
}
