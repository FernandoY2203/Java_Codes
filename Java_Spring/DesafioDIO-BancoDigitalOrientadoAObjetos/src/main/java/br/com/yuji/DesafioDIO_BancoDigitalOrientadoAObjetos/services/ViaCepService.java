package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "viacep.com.br/ws")
public interface ViaCepService {
	
	@GetMapping(value = "/{cep}/json/")
	Endereco consultarCep(@PathVariable("cep") String cep);
}
