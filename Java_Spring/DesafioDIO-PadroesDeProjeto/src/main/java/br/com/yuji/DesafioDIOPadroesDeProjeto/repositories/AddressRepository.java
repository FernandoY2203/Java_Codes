package br.com.yuji.DesafioDIOPadroesDeProjeto.repositories;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {

}
