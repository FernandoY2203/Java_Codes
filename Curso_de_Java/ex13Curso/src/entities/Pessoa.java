
package entities;

public abstract class Pessoa {
    private String nome;
    private Double rendaAnual;

    
    public Pessoa(String nome, Double rendaAnual) {
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(Double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }
    
    
    public abstract double imposto();

    @Override
    public String toString() {
        return nome + ": $" + String.format("%.2f", imposto());
    }
}
