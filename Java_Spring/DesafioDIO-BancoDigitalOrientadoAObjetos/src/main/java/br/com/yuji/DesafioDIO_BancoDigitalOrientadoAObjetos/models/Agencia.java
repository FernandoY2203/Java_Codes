package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "agencias")
public class Agencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "agencia")
    private List<Contas> contas = new ArrayList<>();


    public Agencia() {
    }


    public Long getId() {
        return id;
    }

    @JsonIgnore
    public List<Contas> getContas() {
        return contas;
    }

    public void addConta(Contas conta) {
        this.contas.add(conta);
    }

    public void removeConta(Contas conta) {
        this.contas.remove(conta);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agencia agencia = (Agencia) o;
        return Objects.equals(id, agencia.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
