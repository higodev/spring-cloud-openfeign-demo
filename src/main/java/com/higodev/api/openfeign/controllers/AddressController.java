package com.higodev.api.openfeign.controllers;

import com.higodev.api.openfeign.dtos.ViaCepResponseDTO;
import com.higodev.api.openfeign.clients.ViaCepWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private ViaCepWS viaCepWS;

    @GetMapping("/{cep}")
    public ViaCepResponseDTO findByCep(@PathVariable String cep){

        ViaCepResponseDTO response = null;

        try{
            response = viaCepWS.retornarEndereco(cep);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.REQUEST_TIMEOUT, e.getMessage());
        }

        return response;

    }

}
