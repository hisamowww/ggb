package com.example.ggb.services;

import com.example.ggb.entyties.Mestorog;
import com.example.ggb.entyties.Org;
import com.example.ggb.repositories.MestorogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MestorogService {

    private MestorogRepository mestorogRepository;

    public MestorogService(MestorogRepository mestorogRepository) {
        this.mestorogRepository = mestorogRepository;
    }
    public List<Mestorog> listMestorog(){
        return (List<Mestorog>) mestorogRepository.findAll();
    }
}
