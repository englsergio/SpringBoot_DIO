package one.digitalinnovation.labpadroesprojetospring.service.impl;

import one.digitalinnovation.labpadroesprojetospring.model.Cliente;
import one.digitalinnovation.labpadroesprojetospring.model.ClienteRepository;
import one.digitalinnovation.labpadroesprojetospring.model.Endereco;
import one.digitalinnovation.labpadroesprojetospring.model.EnderecoRepository;
import one.digitalinnovation.labpadroesprojetospring.service.ClienteService;
import one.digitalinnovation.labpadroesprojetospring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação da Strategy {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um Singleton.
 */
@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        //Verifica se o endereço do cliente já existe (pelo Cep)
        salvarClienteComEndereco(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteById = clienteRepository.findById(id);
        if(clienteById.isPresent()) {
            salvarClienteComEndereco(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
    private void salvarClienteComEndereco(Cliente cliente) {
        String cep = cliente.getEndereço().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            //Caso não exista, integrar com o ViaCEP e persistir o retorno (endereço)
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereço(endereco);
        clienteRepository.save(cliente);
    }
}
