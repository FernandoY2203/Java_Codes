package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.repositories;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Contas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasRepository extends JpaRepository<Contas, Long> {
}
