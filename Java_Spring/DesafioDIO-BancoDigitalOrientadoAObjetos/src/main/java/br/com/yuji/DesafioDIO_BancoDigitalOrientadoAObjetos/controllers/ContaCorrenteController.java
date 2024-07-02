package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.controllers;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.ContaCorrente;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Contas;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.repositories.ContasRepository;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/contaCorrente")
public class ContaCorrenteController {

    @Autowired
    private ContaCorrenteService service;
    @Autowired
    private ContasRepository contasRepository;


    @GetMapping
    public ResponseEntity<Iterable<ContaCorrente>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContaCorrente> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ContaCorrente> insert(@RequestBody ContaCorrente contaCorrente) {
        contaCorrente = service.insert(contaCorrente);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contaCorrente.getId()).toUri();

        return ResponseEntity.created(uri).body(contaCorrente);
    }

    @PutMapping
    public ResponseEntity<ContaCorrente> update(@RequestBody ContaCorrente contaCorrente) {
        return ResponseEntity.ok().body(service.update(contaCorrente));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }


    @PatchMapping(value = "/sacar/{id}")
    public ResponseEntity<Void> sacar(@PathVariable Long id, @RequestBody Double valor) {
        ContaCorrente contaCorrente = service.findById(id);

        service.sacar(valor, contaCorrente);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/depositar/{id}")
    public ResponseEntity<Void> depositar(@PathVariable Long id, @RequestBody Double valor) {
        ContaCorrente contaCorrente = service.findById(id);

        service.depositar(valor, contaCorrente);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/transferir/{id}/{idTransferir}")
    public ResponseEntity<Void> transferir(@PathVariable Long id, @PathVariable Long idTransferir, @RequestBody Double valor) {
        ContaCorrente contaCorrente = service.findById(id);
        Contas auxConta = contasRepository.getReferenceById(idTransferir);

        service.transferir(valor, contaCorrente, auxConta);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/usarCredito/{id}")
    public ResponseEntity<Void> usarCredito(@PathVariable Long id, @RequestBody Double valor) {
        ContaCorrente contaCorrente = service.findById(id);

        service.usarCredito(valor, contaCorrente);

        return ResponseEntity.noContent().build();
    }
}
