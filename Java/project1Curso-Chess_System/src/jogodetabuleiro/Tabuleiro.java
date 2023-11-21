
package jogodetabuleiro;

public class Tabuleiro {
    private Integer linhas;
    private Integer colunas;
    
    private Peca[][] pcs;

//----------------------------------------------------------------------------------------------------------------//
    
    public Tabuleiro(Integer linhas, Integer colunas) {
        if(linhas < 1 || colunas < 1){
            throw new ExcecaoDoTabuleiro("Erro criando o tabuleiro, deve ter pelo menos 1 linha e 1 coluna");
        }
        
        this.linhas = linhas;
        this.colunas = colunas;
        
        this.pcs = new Peca[linhas][colunas];
    }

//----------------------------------------------------------------------------------------------------------------//
    
    public Integer getLinhas() {
        return linhas;
    }

    public Integer getColunas() {
        return colunas;
    }

//----------------------------------------------------------------------------------------------------------------//
    
    public Peca peca(int linha, int coluna){
        if(!posicaoExiste(linha, coluna)){
            throw new ExcecaoDoTabuleiro("Tabuleiro não contem essa posição");
        }
        
        return pcs[linha][coluna];
    }
    
    public Peca peca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new ExcecaoDoTabuleiro("Tabuleiro não contem essa posição");
        }
        
        return pcs[posicao.getLinha()][posicao.getColuna()];
    }
    
    public void colocarPeca(Peca peca, Posicao posicao){
        if(temUmaPeca(posicao)){
            throw new ExcecaoDoTabuleiro("Já há uma peça nesta posição: " + posicao);
        }
        
        pcs[posicao.getLinha()][posicao.getColuna()] = peca;
        
        peca.posicao = posicao;
    }
    
    public Peca removerPeca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new ExcecaoDoTabuleiro("Tabuleiro não contem essa posição");
        }
        
        if(peca(posicao) == null){
            return null;
        }
        
        Peca aux = peca(posicao);
        aux.posicao = null;
        
        pcs[posicao.getLinha()][posicao.getColuna()] = null;
        
        return aux;
    }
   
    private boolean posicaoExiste(int linha, int coluna){
        return (linha >= 0 && linha < linhas) && (coluna >= 0 && coluna < colunas);
    }
    
    public boolean posicaoExiste(Posicao posicao){
        return posicaoExiste(posicao.getLinha(), posicao.getColuna());
    }
    
    public boolean temUmaPeca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new ExcecaoDoTabuleiro("Tabuleiro não contem essa posição");
        }
        
        return peca(posicao) != null;
    }
}
