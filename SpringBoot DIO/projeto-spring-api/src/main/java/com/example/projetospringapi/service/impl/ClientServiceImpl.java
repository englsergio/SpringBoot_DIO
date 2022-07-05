package com.example.projetospringapi.service.impl;

import com.example.projetospringapi.model.Address;
import com.example.projetospringapi.model.AddressRepository;
import com.example.projetospringapi.model.Client;
import com.example.projetospringapi.model.ClientRepository;
import com.example.projetospringapi.service.ClientService;
import com.example.projetospringapi.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        //Verify if the address already exists.
        saveClientWithAddressChecking(client);
    }


    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientCheck = clientRepository.findById(id);
        if(clientCheck.isPresent()) {
            saveClientWithAddressChecking(client);
        } else {
            ResponseEntity.badRequest();
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientWithAddressChecking(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.lookForCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }
}
