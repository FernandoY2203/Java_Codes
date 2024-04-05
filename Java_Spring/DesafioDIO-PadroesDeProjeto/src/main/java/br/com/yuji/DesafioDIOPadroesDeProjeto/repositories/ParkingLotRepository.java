package br.com.yuji.DesafioDIOPadroesDeProjeto.repositories;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {

}
