
package xadrez.pecas;

import jogodetabuleiro.Posicao;
import jogodetabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

public class Peao extends PecaDeXadrez{
    
    public Peao(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }
    
    //----------------------------------------------------------------------------------------------------------------//
    
    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        
        Posicao p = new Posicao(0, 0);
        
        if(getCor() == Cor.WHITE){
            //Branco 
            
            //Movimento Inicial
            p.setValores(posicao.getLinha() - 1, posicao.getColuna()); 

            if(getContadorDeMovimento() == 0){
                for (int i = 0; i < 2; i++) {
                    if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
                        mat[p.getLinha()][p.getColuna()] = true;
                        
                        p.setLinha(p.getLinha() - 1);
                    }
                    else{
                        break;
                    }
                }
            }
            
            //Movimento Padrao
            p.setValores(posicao.getLinha() - 1, posicao.getColuna()); 

            if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
                    mat[p.getLinha()][p.getColuna()] = true;
            }
            
            //Captura Esquerda
            p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
            
            if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            
            //Captura Direita
            p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
            
            if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
        }
        else{
            //Preto
            
            //Movimento Inicial
            p.setValores(posicao.getLinha() + 1, posicao.getColuna()); 

            if(getContadorDeMovimento() == 0){
                for (int i = 0; i < 2; i++) {
                    if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
                        mat[p.getLinha()][p.getColuna()] = true;
                        
                        p.setLinha(p.getLinha() + 1);
                    }
                    else{
                        break;
                    }
                }
            }
            
            //Movimento Padrao
            p.setValores(posicao.getLinha() + 1, posicao.getColuna()); 

            if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
                    mat[p.getLinha()][p.getColuna()] = true;
            }
            
            //Captura Esquerda
            p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
            
            if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            
            //Captura Direita
            p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
            
            if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
        }
        
        return mat;
    }
}
