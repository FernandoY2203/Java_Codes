package br.com.yuji.DesafioDIOPadroesDeProjeto.controllers;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.ParkingLotDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.ParkingLotService;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.impl.ParkingLotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/parkingLot")
public class ParkingLotController {

    @Autowired
    private ParkingLotService service;


    @GetMapping
    public ResponseEntity<Iterable<ParkingLotDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParkingLotDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ParkingLotDTO> insert(@RequestBody ParkingLotDTO parkingLotDTO) {
        parkingLotDTO = service.insert(parkingLotDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(parkingLotDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(parkingLotDTO);
    }

    @PutMapping
    public ResponseEntity<ParkingLotDTO> update(@RequestBody ParkingLotDTO parkingLotDTO) {
        return ResponseEntity.ok().body(service.update(parkingLotDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
