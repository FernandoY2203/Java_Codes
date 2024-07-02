package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.controllers;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Agencia;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/agencia")
public class AgenciaController {

    @Autowired
    private AgenciaService service;


    @GetMapping
    public ResponseEntity<Iterable<Agencia>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Agencia> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Agencia> insert(@RequestBody Agencia agencia) {
        agencia = service.insert(agencia);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(agencia.getId()).toUri();

        return ResponseEntity.created(uri).body(agencia);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
