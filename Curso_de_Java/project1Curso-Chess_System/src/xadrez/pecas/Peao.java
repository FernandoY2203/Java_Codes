
package xadrez.pecas;

import jogodetabuleiro.Posicao;
import jogodetabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;

public class Peao extends PecaDeXadrez{
    
    private final PartidaDeXadrez partidaDeXadrez;
    
    //----------------------------------------------------------------------------------------------------------------//
    
    public Peao(Cor cor, Tabuleiro tabuleiro, PartidaDeXadrez partidaDeXadrez) {
        super(cor, tabuleiro);
        this.partidaDeXadrez = partidaDeXadrez;
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
            
            ///Movimento Inicial
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
            
            ///Movimento Padrao
            p.setValores(posicao.getLinha() - 1, posicao.getColuna()); 

            if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
                    mat[p.getLinha()][p.getColuna()] = true;
            }
            
            ///Captura Esquerda
            p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
            
            if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            
            ///Captura Direita
            p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
            
            if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            
            
            //Movimento Especial: En Passant
            if(posicao.getLinha() == 3){
                ///Esquerda
                Posicao esq = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
                
                if(getTabuleiro().posicaoExiste(esq) && haPecaDoOponente(esq) && getTabuleiro().peca(esq) == partidaDeXadrez.getEnPassantVulneravel()){
                    mat[esq.getLinha() - 1][esq.getColuna()] = true;
                }
                
                ///Direita
                Posicao dir = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
                
                if(getTabuleiro().posicaoExiste(dir) && haPecaDoOponente(dir) && getTabuleiro().peca(dir) == partidaDeXadrez.getEnPassantVulneravel()){
                    mat[dir.getLinha() - 1][dir.getColuna()] = true;
                }
            }
            
        }
        else{
            //Preto
            
            ///Movimento Inicial
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
            
            ///Movimento Padrao
            p.setValores(posicao.getLinha() + 1, posicao.getColuna()); 

            if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
                    mat[p.getLinha()][p.getColuna()] = true;
            }
            
            ///Captura Esquerda
            p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
            
            if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            
            ///Captura Direita
            p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
            
            if(getTabuleiro().posicaoExiste(p) && haPecaDoOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            
            
            //Movimento Especial: En Passant
            if(posicao.getLinha() == 4){
                ///Esquerda
                Posicao esq = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
                
                if(getTabuleiro().posicaoExiste(esq) && haPecaDoOponente(esq) && getTabuleiro().peca(esq) == partidaDeXadrez.getEnPassantVulneravel()){
                    mat[esq.getLinha() + 1][esq.getColuna()] = true;
                }
                
                ///Direita
                Posicao dir = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
                
                if(getTabuleiro().posicaoExiste(dir) && haPecaDoOponente(dir) && getTabuleiro().peca(dir) == partidaDeXadrez.getEnPassantVulneravel()){
                    mat[dir.getLinha() + 1][dir.getColuna()] = true;
                }
            }
        }
        
        return mat;
    }
}
