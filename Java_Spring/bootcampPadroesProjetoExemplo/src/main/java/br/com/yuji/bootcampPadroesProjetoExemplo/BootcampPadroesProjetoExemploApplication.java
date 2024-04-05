package br.com.yuji.bootcampPadroesProjetoExemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BootcampPadroesProjetoExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampPadroesProjetoExemploApplication.class, args);
	}

}
