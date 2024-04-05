package br.com.yuji.DesafioDIOPadroesDeProjeto.repositories;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.ParkingLot;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Vehicle;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.ParkingLotDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.VehicleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    Optional<Vehicle> findByLicensePlate(String licensePlate);

    List<Vehicle> findByParkingLot(ParkingLot parkingLot);
}
