package com.example.ggb.services;

import com.example.ggb.entyties.Post;
import com.example.ggb.entyties.Sotrud;
import com.example.ggb.repositories.SotrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SotrudService {

    private SotrudRepository sotrudRepository;

    public SotrudService(SotrudRepository sotrudRepository) {
        this.sotrudRepository = sotrudRepository;
    }

    public List<Sotrud> listSotruds(){
        return (List<Sotrud>) sotrudRepository.findAll();
    }
}
