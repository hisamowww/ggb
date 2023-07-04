package com.example.ggb.services;

import com.example.ggb.entyties.Sotrud;
import com.example.ggb.entyties.Work;
import com.example.ggb.repositories.WorkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService {

    private WorkRepository workRepository;

    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    public List<Work> listWorks(){
        return (List<Work>) workRepository.findAll();
    }
}
