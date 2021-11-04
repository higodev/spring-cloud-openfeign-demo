package com.higodev.api.openfeign.clients;

import com.higodev.api.openfeign.dtos.ViaCepResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCep", url = "https://viacep.com.br/ws")
public interface ViaCepWS {

    @GetMapping("/{cep}/json")
    ViaCepResponseDTO retornarEndereco(@PathVariable String cep);

}
