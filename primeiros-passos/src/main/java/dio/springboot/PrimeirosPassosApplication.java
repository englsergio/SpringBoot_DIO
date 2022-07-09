package dio.springboot;

import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrimeirosPassosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeirosPassosApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(ConversorJson conversor) throws Exception {
		return args -> {
			String json = "{\"cep\": \"01001-000\",\"logradouro\":  \"Praça da Sé\",\"localidade\": \"São Paulo\"}";
			ViaCepResponse response = conversor.converter(json);
			System.out.println("Dados do CEP: " + response);
		};
	}
	//Formas de tornar a biblioteca externa Gson um BEAN:
	//Essa maneira pode poluir a classe principal caso seja necessário
	//adicionar muitos @Beans. A outra maneira é criar uma classe BeansFactory
//	@Bean
//	public Gson gson() {
//		return new Gson();
//	}

}
