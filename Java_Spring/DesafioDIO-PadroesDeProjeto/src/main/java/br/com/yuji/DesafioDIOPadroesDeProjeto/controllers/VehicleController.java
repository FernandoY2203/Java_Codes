package br.com.yuji.DesafioDIOPadroesDeProjeto.controllers;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.ParkingLot;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Vehicle;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.ParkingLotDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.VehicleDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.ParkingLotService;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.VehicleService;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.impl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;
    @Autowired
    private ParkingLotService parkingLotService;


    @GetMapping(value = "/parkingLot")
    public ResponseEntity<Iterable<VehicleDTO>> findByParkingLot(@RequestParam Long parkingLotId) {
        ParkingLotDTO aux = parkingLotService.findById(parkingLotId);

        return ResponseEntity.ok().body(service.findByParkingLot(aux));
    }

    @GetMapping
    public ResponseEntity<VehicleDTO> findByLicensePlate(@RequestParam String licensePlate) {
        return ResponseEntity.ok().body(service.findByLicensePlate(licensePlate));
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> insert(@RequestBody VehicleDTO vehicleDTO, @RequestParam Long parkingLotId) {
        ParkingLotDTO aux = parkingLotService.findById(parkingLotId);
        vehicleDTO = service.insert(vehicleDTO, aux);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vehicleDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(vehicleDTO);
    }

    @PutMapping
    public ResponseEntity<VehicleDTO> update(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok().body(service.update(vehicleDTO));
    }

    @DeleteMapping(value = "/{licensePlate}")
    public ResponseEntity<Void> delete(@PathVariable String licensePlate) {
        service.delete(licensePlate);

        return ResponseEntity.noContent().build();
    }
}
