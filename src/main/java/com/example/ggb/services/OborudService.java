package com.example.ggb.services;

import com.example.ggb.entyties.Oborud;
import com.example.ggb.entyties.Org;
import com.example.ggb.repositories.OborudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OborudService {

    private OborudRepository oborudRepository;

    public OborudService(OborudRepository oborudRepository) {
        this.oborudRepository = oborudRepository;
    }

    public List<Oborud> listOborud(){
        return (List<Oborud>) oborudRepository.findAll();
    }
}
