package br.com.yuji.DesafioDIOPadroesDeProjeto.services;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.ParkingLotDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.VehicleDTO;

public interface VehicleService {

    Iterable<VehicleDTO> findByParkingLot(ParkingLotDTO parkingLotDTO);

    VehicleDTO findByLicensePlate(String licensePlate);

    VehicleDTO insert(VehicleDTO vehicleDTO, ParkingLotDTO parkingLotDTO);

    VehicleDTO update(VehicleDTO VehicleDTO);

    void delete(String licensePlate);
}
