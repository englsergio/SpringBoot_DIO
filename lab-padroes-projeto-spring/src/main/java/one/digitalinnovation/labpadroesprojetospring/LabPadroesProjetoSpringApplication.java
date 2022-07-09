package one.digitalinnovation.labpadroesprojetospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto SpringBoot gerado via Spring Initializr
 * Os seguintes módulos foram selecionados:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - Open Feign
 * - OpenApi.ui/Swagger (inserido manualmente)
 */
@EnableFeignClients
@SpringBootApplication
public class LabPadroesProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesProjetoSpringApplication.class, args);
	}

}
