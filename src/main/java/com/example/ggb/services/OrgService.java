package com.example.ggb.services;

import com.example.ggb.entyties.Org;
import com.example.ggb.repositories.OrgRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgService {


    private OrgRepository orgRepository;

    public OrgService(OrgRepository orgRepository) {
        this.orgRepository = orgRepository;
    }

    public List<Org> listOrg(){
        return (List<Org>) orgRepository.findAll();
    }



}
