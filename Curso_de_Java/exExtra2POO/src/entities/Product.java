
package entities;

public class Product {
    public String nome;
    public double preco;
    public int qtd;

    public double ValorTotalNoEstoque(){
        return preco * qtd;
    }

    public void AdicionarProdutos(int quanti){
        qtd += quanti;
    }

    public void RemoverProdutos(int quanti){
        qtd -= quanti;
    }
}
