package br.com.yuji.DesafioDIOPadroesDeProjeto.services.impl;

import br.com.yuji.DesafioDIOPadroesDeProjeto.config.MapperConfig;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Address;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.ParkingLot;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Telephone;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.ParkingLotDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.repositories.AddressRepository;
import br.com.yuji.DesafioDIOPadroesDeProjeto.repositories.ParkingLotRepository;
import br.com.yuji.DesafioDIOPadroesDeProjeto.repositories.TelephoneRepository;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.ParkingLotService;
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
public class ParkingLotServiceImpl implements ParkingLotService {

    private final Logger logger = Logger.getLogger(ParkingLotServiceImpl.class.getName());

    @Autowired
    private ParkingLotRepository repository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private TelephoneRepository telephoneRepository;
    @Autowired
    private MapperConfig mapper;
    @Autowired
    private ViaCepService viaCepService;


    @Override
    public Iterable<ParkingLotDTO> findAll() {
        logger.info("Finding all Parking Lots...");

        return mapper.toListParkingLotDTOs(repository.findAll());
    }

    @Override
    public ParkingLotDTO findById(Long id) {
        logger.info("Finding Parking Lot...");

        ParkingLot entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        return mapper.toParkingLotDTO(entity);
    }

    @Override
    public ParkingLotDTO insert(ParkingLotDTO parkingLotDTO) {
        logger.info("Inserting a Parking Lot...");

        ParkingLot entity = mapper.toParkingLot(parkingLotDTO);
        String cep = entity.getAddress().getCep();
        Address address = addressCheck(cep);

        entity.setAddress(address);

        return mapper.toParkingLotDTO(repository.save(entity));
    }

    @Override
    public ParkingLotDTO update(ParkingLotDTO parkingLotDTO) {
        logger.info("Updating Parking Lot...");

        try {
            ParkingLot entity = repository.getReferenceById(parkingLotDTO.getId());

            updateData(entity, parkingLotDTO);

            return mapper.toParkingLotDTO(repository.save(entity));
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(parkingLotDTO.getId());
        }
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting Parking Lot...");

        try {
            Optional<ParkingLot> p = repository.findById(id);

            repository.delete(p.get());
        }
        catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }


    private Address addressCheck(String cep) {
        return addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.consultarCep(cep);

            return addressRepository.save(newAddress);
        });
    }

    private void updateData(ParkingLot entity, ParkingLotDTO parkingLotDTO) {
        entity.setName(parkingLotDTO.getName());
        entity.setCnpj(parkingLotDTO.getCnpj());
        entity.setSpaceForCars(parkingLotDTO.getSpaceForCars());
        entity.setSpaceForMotorcycles(parkingLotDTO.getSpaceForMotorcycles());
        entity.setAddress(addressCheck(parkingLotDTO.getAddressDTO().getCep()));
    }
}
