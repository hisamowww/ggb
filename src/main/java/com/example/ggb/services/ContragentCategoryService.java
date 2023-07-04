package com.example.ggb.services;

import com.example.ggb.entyties.ContragentCategory;
import com.example.ggb.entyties.Org;
import com.example.ggb.repositories.ContragentCategoryRepository;
import com.example.ggb.repositories.OrgRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContragentCategoryService {
    private ContragentCategoryRepository contragentCategoryRepository;

    public ContragentCategoryService(ContragentCategoryRepository contragentCategoryRepository) {
        this.contragentCategoryRepository = contragentCategoryRepository;
    }

    public List<ContragentCategory> listContragentCategory(){
        return (List<ContragentCategory>) contragentCategoryRepository.findAll();
    }
}
