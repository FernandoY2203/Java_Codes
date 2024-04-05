package br.com.yuji.DesafioDIOPadroesDeProjeto.services.impl;

import br.com.yuji.DesafioDIOPadroesDeProjeto.config.MapperConfig;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Address;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.ParkingLot;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Telephone;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Vehicle;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.ParkingLotDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.VehicleDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.enums.VehicleType;
import br.com.yuji.DesafioDIOPadroesDeProjeto.repositories.AddressRepository;
import br.com.yuji.DesafioDIOPadroesDeProjeto.repositories.ParkingLotRepository;
import br.com.yuji.DesafioDIOPadroesDeProjeto.repositories.TelephoneRepository;
import br.com.yuji.DesafioDIOPadroesDeProjeto.repositories.VehicleRepository;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.ParkingLotService;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.VehicleService;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.ViaCepService;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.exceptions.DatabaseException;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final Logger logger = Logger.getLogger(VehicleServiceImpl.class.getName());

    @Autowired
    private VehicleRepository repository;
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private MapperConfig mapper;


    @Override
    public Iterable<VehicleDTO> findByParkingLot(ParkingLotDTO parkingLotDTO) {
        logger.info("Finding all Vehicles of Parking Lot...");

        return mapper.toListVehicleDTOs(repository.findByParkingLot(mapper.toParkingLot(parkingLotDTO)));
    }

    @Override
    public VehicleDTO findByLicensePlate(String licensePlate) {
        logger.info("Finding Vehicle...");

        Vehicle entity = repository.findByLicensePlate(licensePlate).orElseThrow(() -> new ResourceNotFoundException(licensePlate));

        return mapper.toVehicleDTO(entity);
    }

    @Override
    public VehicleDTO insert(VehicleDTO vehicleDTO, ParkingLotDTO parkingLotDTO) {
        logger.info("Inserting a Vehicle...");

        Vehicle entity = mapper.toVehicle(vehicleDTO);
        ParkingLot aux = mapper.toParkingLot(parkingLotDTO);

        entity.setParkingLot(aux);
        entity = repository.save(entity);

        aux.addVehicles(entity);
        parkingLotRepository.save(aux);

        return mapper.toVehicleDTO(repository.save(entity));
    }

    @Override
    public VehicleDTO update(VehicleDTO vehicleDTO) {
        logger.info("Updating Vehicle...");

        try {
            Vehicle entity = repository.getReferenceById(vehicleDTO.getId());

            updateData(entity, vehicleDTO);

            return mapper.toVehicleDTO(repository.save(entity));
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(vehicleDTO.getId());
        }
    }

    @Override
    public void delete(String licensePlate) {
        logger.info("Deleting Vehicle...");

        try {
            Optional<Vehicle> v = repository.findByLicensePlate(licensePlate);
            ParkingLot aux = parkingLotRepository.getReferenceById(v.get().getParkingLot().getId());

            aux.removeVehicle(v.get());

            repository.delete(v.get());
        }
        catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(licensePlate);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }


    private void updateData(Vehicle entity, VehicleDTO vehicleDTO) {
        entity.setBrand(vehicleDTO.getBrand());
        entity.setModel(vehicleDTO.getModel());
        entity.setColor(vehicleDTO.getColor());
    }
}
