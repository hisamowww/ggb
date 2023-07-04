package com.example.ggb.controllers;

import com.example.ggb.entyties.Contragent;
import com.example.ggb.entyties.ContragentObject;
import com.example.ggb.entyties.Mestorog;
import com.example.ggb.entyties.Org;
import com.example.ggb.repositories.ContragentObjectRepository;
import com.example.ggb.repositories.ContragentRepository;
import com.example.ggb.repositories.MestorogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContragentObjectController {
    @Autowired
    private ContragentObjectRepository contragentObjectRepository;
    @Autowired
    private MestorogRepository mestorogRepository;
    @Autowired
    private ContragentRepository contragentRepository;

    @GetMapping("/library/contragentObjects")
    public String listContragentObject (Model model) {
        List<ContragentObject> listContragentObjects = (List<ContragentObject>) contragentObjectRepository.findAll();
        model.addAttribute("listContragentObjects", listContragentObjects);
        return "contragentObjects";
    }

    @GetMapping("/library/contragentObjects/new")
    public String showContragentObjectsNewForm (Model model) {
        model.addAttribute("contragentObject", new ContragentObject());
        List<Mestorog> listMestorogs = (List<Mestorog>) mestorogRepository.findAll();
        List<Contragent> listContragents = (List<Contragent>) contragentRepository.findAll();
        model.addAttribute("listMestorogs", listMestorogs);
        model.addAttribute("listContragents", listContragents);
        return "contragentObjects-add";
    }
    @PostMapping("/library/contragentObjects/save")
    public String saveContragentObject(ContragentObject contragentObject){
        contragentObjectRepository.save(contragentObject);
        return "redirect:/library/contragentObjects";
    }
    @GetMapping("/library/contragentObjects/edit/{id}")
    public String showEditContragentObjectForm (@PathVariable("id") Long id, Model model) {
        ContragentObject contragentObject = contragentObjectRepository.findById(id).get();
        List<Mestorog> listMestorogs = (List<Mestorog>) mestorogRepository.findAll();
        List<Contragent> listContragents = (List<Contragent>) contragentRepository.findAll();
        model.addAttribute("contragentObject", contragentObject);
        model.addAttribute("listMestorogs", listMestorogs);
        model.addAttribute("listContragents", listContragents);
        return "contragentObjects-add";
    }
    @GetMapping("/library/contragentObjects/delete/{id}")
    public String deleteContragentObject (@PathVariable("id") Long id, Model model) {
        contragentObjectRepository.deleteById(id);
        return "redirect:/library/contragentObjects";
    }



}
