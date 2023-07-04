package com.example.ggb.services;

import com.example.ggb.entyties.ContragentObject;
import com.example.ggb.repositories.ContragentObjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContragentObjectService {

    private ContragentObjectRepository contragentObjectRepository;

    public ContragentObjectService(ContragentObjectRepository contragentObjectRepository) {
        this.contragentObjectRepository = contragentObjectRepository;
    }

    public List<ContragentObject> listContragentObjects(){
        return (List<ContragentObject>) contragentObjectRepository.findAll();
    }
}
