package atv2CarrinhoDeCompras;

public class Item {
    
    private String nome;
    private Double preco;
    private Integer qtd;

    public Item(String nome, Double preco, Integer qtd) {
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQtd() {
        return qtd;
    }
    

    @Override
    public String toString() {
        return "Nome: " + nome + " / Preço: " + preco + " / Quantidade: " + qtd;
    }
}
