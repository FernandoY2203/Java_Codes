package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "contaPoupanca")
public class ContaPoupanca extends Contas {

    private static final Double TAXA_SAQUE = 5.00;
    private static final Double TAXA_REFERENCIAL = 0.000915;
    private static final Double SELIC = 0.1050;

    private Integer limite;


    public ContaPoupanca() {
    }

    public ContaPoupanca(Cliente cliente, Agencia agencia, Integer limite) {
        super(cliente, agencia);
        this.limite = limite;
    }


    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }


    public void calcularRemuneracaoMensal() {
        double porcentagemMensal;

        if(SELIC > 0.085) { // 8.5%
            porcentagemMensal = 0.005 + TAXA_REFERENCIAL;
        }
        else {
            porcentagemMensal = (0.7 * SELIC) + TAXA_REFERENCIAL;
        }

        saldo += saldo * porcentagemMensal;
    }

    @Override
    public void sacar(Double valor) {
        if(limite == 0) {
            super.sacar(valor + TAXA_SAQUE);
        }
        else {
            super.sacar(valor);
            limite--;
        }
    }
}
