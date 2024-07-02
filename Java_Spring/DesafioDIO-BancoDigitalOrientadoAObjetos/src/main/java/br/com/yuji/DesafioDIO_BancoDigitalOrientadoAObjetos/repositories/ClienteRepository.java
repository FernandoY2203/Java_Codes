package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.repositories;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
