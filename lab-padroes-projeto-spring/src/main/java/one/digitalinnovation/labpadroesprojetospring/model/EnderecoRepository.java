package one.digitalinnovation.labpadroesprojetospring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Não seria necessário, mas melhora o entendimento da classe
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
