package dio.springboot.properties_values;

import dio.springboot.properties_values.app.SistemaMensagem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PropertiesValuesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertiesValuesApplication.class, args);
	}
//	@Bean
//	public CommandLineRunner run(SistemaMensagem sistema) throws Exception {
//		return args -> {
//
//		};
//	}

}
