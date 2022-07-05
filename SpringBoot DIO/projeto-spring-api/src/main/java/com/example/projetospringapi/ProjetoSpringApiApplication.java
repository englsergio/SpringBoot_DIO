package com.example.projetospringapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProjetoSpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringApiApplication.class, args);
	}

}
