
package entities;

public class Conta {
    private int numConta;
    private String nomeConta;
    private double saldo;

    public Conta(int numConta, String nomeConta, double saldo) {
        this.numConta = numConta;
        this.nomeConta = nomeConta;
        this.saldo = saldo;
    }

    public Conta(int numConta, String nomeConta) {
        this.numConta = numConta;
        this.nomeConta = nomeConta;
    }

    public int getNumConta() {
        return numConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public double getSaldo() {
        return saldo;
    }

    
    public void deposito(double qtd){
        saldo += qtd;
    }
    
    public void saque(double qtd){
        saldo -= (qtd + 5);
    }

    @Override
    public String toString() {
        return "Conta: " + numConta + ", Nome do Titular: " + nomeConta + ", Saldo: $" + String.format("%.2f", saldo);
    }
}
