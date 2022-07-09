package dio.springboot;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //A depender da versão do Spring Boot é necessário inserir essa anotação
public class BeansFactory {
    @Bean
    public Gson gson() {
        return new Gson();
    }
}
