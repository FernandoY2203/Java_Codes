package com.cursojava.project2_WebServices.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	private Contact contato() {
		return new Contact().name("Fernando Yuji").url("http://semSite.com.br").email("yuji.mochizuki@gmail.com");
	}
	
	private Info infoApi() {
		Info apiInfoBuilder = new Info();
		
		apiInfoBuilder.title("REST API - WebService Curso");
		apiInfoBuilder.description("Projeto REST do curso Java");
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
