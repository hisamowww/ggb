package com.example.ggb.services;

import com.example.ggb.entyties.ContragentCategory;
import com.example.ggb.entyties.Podrazd;
import com.example.ggb.repositories.PodrazdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PodrazdService {

    private PodrazdRepository podrazdRepository;

    public PodrazdService(PodrazdRepository podrazdRepository) {
        this.podrazdRepository = podrazdRepository;
    }

    public List<Podrazd> listPodrazds(){
        return (List<Podrazd>) podrazdRepository.findAll();
    }
}
