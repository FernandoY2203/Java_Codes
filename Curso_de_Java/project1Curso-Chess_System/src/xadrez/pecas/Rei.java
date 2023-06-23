
package xadrez.pecas;

import jogodetabuleiro.Posicao;
import jogodetabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;

public class Rei extends PecaDeXadrez{

    private final PartidaDeXadrez partidaDeXadrez;
    
    //----------------------------------------------------------------------------------------------------------------//
    
    public Rei(Cor cor, Tabuleiro tabuleiro, PartidaDeXadrez partidaDeXadrez) {
        super(cor, tabuleiro);
        this.partidaDeXadrez = partidaDeXadrez;
    }
    
    //----------------------------------------------------------------------------------------------------------------//

    private boolean podeMover(Posicao posicao){
        PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(posicao);
        
        return (p == null || p.getCor() != getCor());
    }
    
    private boolean testarRoqueDaTorre(Posicao posicao){
        PecaDeXadrez p = (PecaDeXadrez)getTabuleiro().peca(posicao);
        
        return p != null && p instanceof Torre && p.getCor() == getCor() && p.getContadorDeMovimento() == 0;
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
        
        
        //Movimento Especial: Roque
        if(getContadorDeMovimento() == 0 && !partidaDeXadrez.getXeque()){
            //Lado do Rei
            Posicao posTorre1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 3);
            
            if(testarRoqueDaTorre(posTorre1)){
                Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
                Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() + 2);
                
                if(getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null){
                    mat[p2.getLinha()][p2.getColuna()] = true;
                }
            }
            
            
            //Lado da Dama
            Posicao posTorre2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 4);
            
            if(testarRoqueDaTorre(posTorre2)){
                Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
                Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 2);
                Posicao p3 = new Posicao(posicao.getLinha(), posicao.getColuna() - 3);
                
                if(getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null && getTabuleiro().peca(p3) == null){
                    mat[p2.getLinha()][p2.getColuna()] = true;
                }
            }
        }
        
        return mat;
    }
}
