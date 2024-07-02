package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Agencia;

public interface AgenciaService {

    Iterable<Agencia> findAll();

    Agencia findById(Long numero);

    Agencia insert(Agencia agencia);

    void delete(Long numero);
}
