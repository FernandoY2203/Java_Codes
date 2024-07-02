package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.ContaPoupanca;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Contas;

public interface ContaPoupancaService {

    Iterable<ContaPoupanca> findAll();

    ContaPoupanca findById(Long id);

    ContaPoupanca insert(ContaPoupanca contaPoupanca);

    ContaPoupanca update(ContaPoupanca contaPoupanca);

    void delete(Long id);


    void sacar(Double valor, ContaPoupanca contaPoupanca);

    void depositar(Double valor, ContaPoupanca contaPoupanca);

    void transferir(Double valor, ContaPoupanca contaPoupanca, Contas contaATransferir);

    void calcularRemuneracaoMensal(ContaPoupanca contaPoupanca);
}
