package br.com.yuji.DesafioDIOPadroesDeProjeto.services.impl;

import br.com.yuji.DesafioDIOPadroesDeProjeto.config.MapperConfig;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Address;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.ParkingLot;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Telephone;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.ParkingLotDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.TelephoneDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.repositories.AddressRepository;
import br.com.yuji.DesafioDIOPadroesDeProjeto.repositories.ParkingLotRepository;
import br.com.yuji.DesafioDIOPadroesDeProjeto.repositories.TelephoneRepository;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.ParkingLotService;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.TelephoneService;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.ViaCepService;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.exceptions.DatabaseException;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class TelephoneServiceImpl implements TelephoneService {

    private final Logger logger = Logger.getLogger(TelephoneServiceImpl.class.getName());

    @Autowired
    private TelephoneRepository repository;
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private MapperConfig mapper;


    @Override
    public Iterable<TelephoneDTO> findAll() {
        logger.info("Finding all Telephones...");

        return mapper.toListTelephoneDTOs(repository.findAll());
    }

    @Override
    public TelephoneDTO insert(TelephoneDTO telephoneDTO, ParkingLotDTO parkingLotDTO) {
        logger.info("Inserting a Telephone...");

        Telephone entity = mapper.toTelephone(telephoneDTO);
        ParkingLot aux = mapper.toParkingLot(parkingLotDTO);

        entity.setParkingLot(aux);
        entity = repository.save(entity);

        aux.addTelephone(entity);
        parkingLotRepository.save(aux);

        return mapper.toTelephoneDTO(entity);
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting Parking Lot...");

        try {
            Telephone t = repository.getReferenceById(id);
            ParkingLot aux = parkingLotRepository.getReferenceById(t.getParkingLot().getId());

            aux.removeTelephone(t);

            repository.delete(t);
        }
        catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
