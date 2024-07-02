package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.controllers;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.ContaPoupanca;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Contas;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.repositories.ContasRepository;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.ContaPoupancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/contaPoupanca")
public class ContaPoupancaController {

    @Autowired
    private ContaPoupancaService service;
    @Autowired
    private ContasRepository contasRepository;

    @GetMapping
    public ResponseEntity<Iterable<ContaPoupanca>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContaPoupanca> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ContaPoupanca> insert(@RequestBody ContaPoupanca contaPoupanca) {
        contaPoupanca = service.insert(contaPoupanca);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contaPoupanca.getId()).toUri();

        return ResponseEntity.created(uri).body(contaPoupanca);
    }

    @PutMapping
    public ResponseEntity<ContaPoupanca> update(@RequestBody ContaPoupanca contaPoupanca) {
        return ResponseEntity.ok().body(service.update(contaPoupanca));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }


    @PatchMapping(value = "/sacar/{id}")
    public ResponseEntity<Void> sacar(@PathVariable Long id, @RequestBody Double valor) {
        ContaPoupanca contaPoupanca = service.findById(id);

        service.sacar(valor, contaPoupanca);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/depositar/{id}")
    public ResponseEntity<Void> depositar(@PathVariable Long id, @RequestBody Double valor) {
        ContaPoupanca contaPoupanca = service.findById(id);

        service.depositar(valor, contaPoupanca);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/transferir/{id}/{idTransferir}")
    public ResponseEntity<Void> transferir(@PathVariable Long id, @PathVariable Long idTransferir, @RequestBody Double valor) {
        ContaPoupanca contaPoupanca = service.findById(id);
        Contas auxConta = contasRepository.getReferenceById(idTransferir);

        service.transferir(valor, contaPoupanca, auxConta);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/calcularRemuneracao/{id}")
    public ResponseEntity<Void> calcularRemuneracao(@PathVariable Long id) {
        ContaPoupanca contaPoupanca = service.findById(id);

        service.calcularRemuneracaoMensal(contaPoupanca);

        return ResponseEntity.noContent().build();
    }
}
