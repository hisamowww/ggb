package com.example.ggb.services;


import com.example.ggb.repositories.ProfWorkDocRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfDocWorkService {

    private ProfWorkDocRepository profWorkDocRepository;

    public ProfDocWorkService(ProfWorkDocRepository profWorkDocRepository) {
        this.profWorkDocRepository = profWorkDocRepository;
    }

}
