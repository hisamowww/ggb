package com.example.ggb.services;

import com.example.ggb.entyties.Dogovor;
import com.example.ggb.entyties.Filial;
import com.example.ggb.repositories.DogovorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogovorService {

    private DogovorRepository dogovorRepository;

    public DogovorService(DogovorRepository dogovorRepository) {
        this.dogovorRepository = dogovorRepository;
    }

    public List<Dogovor > listDogovors (){
        return (List<Dogovor>) dogovorRepository.findAll();
    }

}
