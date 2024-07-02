package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.exceptions.AccountNotExistException;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.exceptions.InsufficientFundsException;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Contas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected Double saldo;

    @ManyToOne
    @JoinColumn(name = "cliente_Id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "agencia_Id")
    private Agencia agencia;


    protected Contas() {
    }

    protected Contas(Cliente cliente, Agencia agencia) {
        this.cliente = cliente;
        this.agencia = agencia;
    }


    public Long getId() {
        return id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void sacar(Double valor) {
        if(saldo < valor) {
            throw new InsufficientFundsException("Saque");
        }
        else {
            this.saldo -= valor;
        }
    }

    public void depositar(Double valor) {
        this.saldo += valor;
    }

    public void transferir(Double valor, Contas contaATransferir) {
        if(contaATransferir != null) {
            sacar(valor);
            contaATransferir.depositar(valor);
        }
        else {
            throw new AccountNotExistException();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contas contas = (Contas) o;
        return Objects.equals(id, contas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
