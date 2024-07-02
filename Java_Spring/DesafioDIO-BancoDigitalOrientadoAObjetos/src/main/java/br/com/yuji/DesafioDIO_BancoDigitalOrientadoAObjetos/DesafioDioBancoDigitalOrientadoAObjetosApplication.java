package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioDioBancoDigitalOrientadoAObjetosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioDioBancoDigitalOrientadoAObjetosApplication.class, args);
	}
}
