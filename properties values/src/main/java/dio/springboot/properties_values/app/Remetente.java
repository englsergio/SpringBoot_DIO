package dio.springboot.properties_values.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("remetente") //maneira de obter os dados do application.properties através de um contexto
public class Remetente {
//    @Value("${nome:NoReply}")
    private String nome;
//    @Value("${email}")
    private String email;
//    @Value("${telefones}")
    private List<Long> telefones;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Long> telefones) {
        this.telefones = telefones;
    }
}
