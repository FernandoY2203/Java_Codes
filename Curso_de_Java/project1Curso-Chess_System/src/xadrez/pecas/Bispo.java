
package xadrez.pecas;

import jogodetabuleiro.Posicao;
import jogodetabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

public class Bispo extends PecaDeXadrez{
    
    public Bispo(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }
    
    //----------------------------------------------------------------------------------------------------------------//
    
    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        
        Posicao p = new Posicao(0, 0);
        
        //Cima Esquerda
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
        
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            
            p.setValores(p.getLinha() - 1, p.getColuna() - 1);
        }
        if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //Baixo Esquerda
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
        
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            
            p.setValores(p.getLinha() + 1, p.getColuna() - 1);
        }
        if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //Baixo Direita
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
        
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            
            p.setValores(p.getLinha() + 1, p.getColuna() + 1);
        }
        if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //Cima Direita
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
        
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            
            p.setValores(p.getLinha() - 1, p.getColuna() + 1);
        }
        if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        return mat;
    }
}
