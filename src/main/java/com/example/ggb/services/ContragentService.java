package com.example.ggb.services;

import com.example.ggb.entyties.Contragent;
import com.example.ggb.repositories.ContragentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContragentService {

    private ContragentRepository contragentRepository;

    public ContragentService(ContragentRepository contragentRepository) {
        this.contragentRepository = contragentRepository;
    }

    public List<Contragent> listContragents(){
        return (List<Contragent>) contragentRepository.findAll();
    }
}
