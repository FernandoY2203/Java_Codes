package br.com.yuji.DesafioDIOPadroesDeProjeto.services;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.ParkingLotDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.TelephoneDTO;

public interface TelephoneService {

    Iterable<TelephoneDTO> findAll();

    TelephoneDTO insert(TelephoneDTO TelephoneDTO, ParkingLotDTO parkingLotDTO);

    void delete(Long id);
}
