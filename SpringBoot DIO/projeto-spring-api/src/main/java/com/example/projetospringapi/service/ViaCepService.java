package com.example.projetospringapi.service;

import com.example.projetospringapi.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="viacep", url="https://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping(value = "/{cep}/json/")
    Address lookForCep(@PathVariable("cep") String cep);
}
