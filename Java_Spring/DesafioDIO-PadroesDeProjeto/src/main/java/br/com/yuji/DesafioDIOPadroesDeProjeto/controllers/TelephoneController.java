package br.com.yuji.DesafioDIOPadroesDeProjeto.controllers;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.ParkingLot;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.ParkingLotDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.TelephoneDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.ParkingLotService;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/telephone")
public class TelephoneController {

    @Autowired
    private TelephoneService service;
    @Autowired
    private ParkingLotService parkingLotService;


    @GetMapping
    public ResponseEntity<Iterable<TelephoneDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<TelephoneDTO> insert(@RequestBody TelephoneDTO telephoneDTO, @RequestParam Long parkingLotId) {
        ParkingLotDTO aux = parkingLotService.findById(parkingLotId);
        telephoneDTO = service.insert(telephoneDTO, aux);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(telephoneDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(telephoneDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
