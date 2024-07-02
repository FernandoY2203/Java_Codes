package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.ContaCorrente;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Contas;

public interface ContaCorrenteService {

    Iterable<ContaCorrente> findAll();

    ContaCorrente findById(Long id);

    ContaCorrente insert(ContaCorrente contaCorrente);

    ContaCorrente update(ContaCorrente contaCorrente);

    void delete(Long id);


    void sacar(Double valor, ContaCorrente contaCorrente);

    void depositar(Double valor, ContaCorrente contaCorrente);

    void transferir(Double valor, ContaCorrente contaCorrente, Contas contaATransferir);

    void usarCredito(Double valor, ContaCorrente contaCorrente);
}
