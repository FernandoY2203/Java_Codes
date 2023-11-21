
package entities;

public class Product {
    private String nome;
    private double preco;
    private int qtd;

    
    public Product(){ // Construtor Padrão
    }
    
    public Product(String nome, double preco, int qtd){ // Construtor Com Três Parâmetros
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }

    public Product(String nome, double preco){ // Construtor Com Dois Parâmetros
        this.nome = nome;
        this.preco = preco;
    }

    
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public double ValorTotalNoEstoque(){
        return preco * qtd;
    }

    public void AdicionarProdutos(int quanti){
        qtd += quanti;
    }

    public void RemoverProdutos(int quanti){
        qtd -= quanti;
    }
    
    @Override
    public String toString(){
        return (nome + ", $" + String.format("%.2f", preco) + ", " + qtd + " Unidades, " + "Total: $" + String.format("%.2f", ValorTotalNoEstoque()));
    }
}