package com.example.ggb.services;

import com.example.ggb.entyties.Filial;
import com.example.ggb.entyties.Org;
import com.example.ggb.repositories.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilialService {

    private FilialRepository filialRepository;

    public FilialService(FilialRepository filialRepository) {
        this.filialRepository = filialRepository;
    }

    OrgService orgService;

    public List<Filial> listFilial(){
        return (List<Filial>) filialRepository.findAll();
    }


}
