package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Cliente;

public interface ClienteService {

    Iterable<Cliente> findAll();

    Cliente findById(Long id);

    Cliente insert(Cliente cliente);

    Cliente update(Cliente cliente);

    void delete(Long id);
}
