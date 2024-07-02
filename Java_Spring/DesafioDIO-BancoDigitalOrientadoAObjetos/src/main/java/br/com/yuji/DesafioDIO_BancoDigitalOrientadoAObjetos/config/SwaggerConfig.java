package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
	
	private Contact contato() {
		return new Contact().name("Fernando Yuji").url("http://semSite.com.br").email("yuji.mochizuki@gmail.com");
	}
	
	private Info infoApi() {
		Info apiInfoBuilder = new Info();
		
		apiInfoBuilder.title("REST API - Desafio DIO: Banco Digital com Orientado a Objetos");
		apiInfoBuilder.description("Desafio de Projeto Orientado a Objetos com Spring REST API, Desenvolvendo um Banco Digital");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfService("Termo de Uso: Open Source");
		apiInfoBuilder.license(new License().name("Licença - Sem Licença").url("http://semSite.com.br"));
		apiInfoBuilder.contact(this.contato());
		
		return apiInfoBuilder;
	}
	
	@Bean
	OpenAPI detalheApi() {
		OpenAPI openAPI = new OpenAPI();
		
		openAPI.info(this.infoApi());
		
		return openAPI;
	}
}
