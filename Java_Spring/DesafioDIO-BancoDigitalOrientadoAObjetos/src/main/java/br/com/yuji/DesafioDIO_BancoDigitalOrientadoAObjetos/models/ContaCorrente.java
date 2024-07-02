package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.exceptions.InsufficientFundsException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "contasCorrente")
public class ContaCorrente extends Contas {

    private Double credito;
    private Double limiteChequeEspecial;


    public ContaCorrente() {
    }

    public ContaCorrente(Cliente cliente, Agencia agencia, Double limiteChequeEspecial) {
        super(cliente, agencia);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }


    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }

    public Double getChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.limiteChequeEspecial = chequeEspecial;
    }


    @Override
    public void sacar(Double valor) {
        if(saldo < valor) {
            double aux = valor - saldo;

            if(limiteChequeEspecial < aux) {
                throw new InsufficientFundsException("Saque com Cheque Especial");
            }
            else {
                this.limiteChequeEspecial -= aux;
                super.sacar(saldo);
            }
        }
        else{
            super.sacar(valor);
        }
    }

    public void usarCredito(Double valor) {
        this.credito -= valor;
    }
}
