package br.com.yuji.DesafioDIOPadroesDeProjeto.repositories;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long> {

}
