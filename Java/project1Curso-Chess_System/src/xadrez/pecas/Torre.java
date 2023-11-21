
package xadrez.pecas;

import jogodetabuleiro.Posicao;
import jogodetabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

public class Torre extends PecaDeXadrez{
    
    public Torre(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }
    
    //----------------------------------------------------------------------------------------------------------------//

    @Override
    public String toString() {
        return "T";
    }
    
    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        
        Posicao p = new Posicao(0, 0);
        
        //Cima
        p.setValores(posicao.getLinha() - 1, posicao.getColuna());
        
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            
            p.setLinha(p.getLinha() - 1);
        }
        if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //Esquerda
        p.setValores(posicao.getLinha(), posicao.getColuna() - 1);
        
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            
            p.setColuna(p.getColuna() - 1);
        }
        if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //Baixo
        p.setValores(posicao.getLinha() + 1, posicao.getColuna());
        
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            
            p.setLinha(p.getLinha() + 1);
        }
        if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //Direita
        p.setValores(posicao.getLinha(), posicao.getColuna() + 1);
        
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            
            p.setColuna(p.getColuna() + 1);
        }
        if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        return mat;
    }
}
