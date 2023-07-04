package com.example.ggb.controllers;

import com.example.ggb.entyties.*;
import com.example.ggb.repositories.ContragentRepository;
import com.example.ggb.repositories.DogovorRepository;
import com.example.ggb.repositories.FilialRepository;
import com.example.ggb.repositories.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DogovorController {
    @Autowired
    private ContragentRepository contragentRepository;
    @Autowired
    private OrgRepository orgRepository;
    @Autowired
    private FilialRepository filialRepository;
    @Autowired
    private DogovorRepository dogovorRepository;

    @GetMapping("/library/dogovors")
    public String listDogovors (Model model){
        List<Dogovor> listDogovors = (List<Dogovor>) dogovorRepository.findAll();
        model.addAttribute("listDogovors", listDogovors);
        return "dogovors";
    }
    @GetMapping("/library/dogovors/new")
    public String showDogovorNewForm (Model model){
        model.addAttribute("dogovor", new Dogovor());
        List<Contragent> listContragents = (List<Contragent>) contragentRepository.findAll();
        List<Org> listOrgs = (List<Org>) orgRepository.findAll();
        List<Filial> listFilials = (List<Filial>) filialRepository.findAll();
        model.addAttribute("listOrgs", listOrgs);
        model.addAttribute("listFilials", listFilials);
        model.addAttribute("listContragents", listContragents);
        return "dogovors-add";
    }
    @PostMapping("/library/dogovors/save")
    public String saveDogovor(Dogovor dogovor){
        dogovorRepository.save(dogovor);
        return "redirect:/library/dogovors";
    }
    @GetMapping("/library/dogovors/edit/{id}")
    public String showEditDogovorForm (@PathVariable("id") Long id, Model model) {
        Dogovor dogovor = dogovorRepository.findById(id).get();
        model.addAttribute("dogovor", dogovor);
        List<Contragent> listContragents = (List<Contragent>) contragentRepository.findAll();
        List<Org> listOrgs = (List<Org>) orgRepository.findAll();
        List<Filial> listFilials = (List<Filial>) filialRepository.findAll();
        model.addAttribute("listOrgs", listOrgs);
        model.addAttribute("listFilials", listFilials);
        model.addAttribute("listContragents", listContragents);
        return "dogovors-add";
    }
    @GetMapping("/library/dogovors/delete/{id}")
    public String deleteDogovor (@PathVariable("id") Long id, Model model) {
        dogovorRepository.deleteById(id);
        return "redirect:/library/dogovors";
    }

}
