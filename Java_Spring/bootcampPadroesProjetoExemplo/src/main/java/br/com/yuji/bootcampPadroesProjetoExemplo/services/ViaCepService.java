package br.com.yuji.bootcampPadroesProjetoExemplo.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.yuji.bootcampPadroesProjetoExemplo.models.Address;

@FeignClient(name = "viacep", url = "viacep.com.br/ws")
public interface ViaCepService {
	
	@GetMapping(value = "/{cep}/json/")
	Address consultarCep(@PathVariable("cep") String cep); 
}
