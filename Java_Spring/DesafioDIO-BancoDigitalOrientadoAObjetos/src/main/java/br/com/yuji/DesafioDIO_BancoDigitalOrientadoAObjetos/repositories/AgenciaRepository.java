package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.repositories;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
}
