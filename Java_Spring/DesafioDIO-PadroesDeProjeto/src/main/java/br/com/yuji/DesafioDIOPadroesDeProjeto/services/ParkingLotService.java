package br.com.yuji.DesafioDIOPadroesDeProjeto.services;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.ParkingLotDTO;

public interface ParkingLotService {

    Iterable<ParkingLotDTO> findAll();

    ParkingLotDTO findById(Long id);

    ParkingLotDTO insert(ParkingLotDTO parkingLotDTO);

    ParkingLotDTO update(ParkingLotDTO parkingLotDTO);

    void delete(Long id);
}
