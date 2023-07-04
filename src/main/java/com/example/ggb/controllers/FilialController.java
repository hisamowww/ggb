package com.example.ggb.controllers;

import com.example.ggb.entyties.Filial;
import com.example.ggb.entyties.Org;
import com.example.ggb.repositories.FilialRepository;
import com.example.ggb.repositories.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class FilialController {
    @Autowired
    private FilialRepository filialRepository;
    @Autowired
    private OrgRepository orgRepository;


    @GetMapping("/library/filials")
    public String listFilials(Model model){
        List<Filial> listFilials = (List<Filial>) filialRepository.findAll();
        model.addAttribute("listFilials", listFilials);
        return "filials";
    }
    @GetMapping("/library/filials/new")
    public String showFilialNewForm (Model model)  {
        List<Org> listOrgs = (List<Org>) orgRepository.findAll();
        model.addAttribute("filial", new Filial());
        model.addAttribute("listOrgs", listOrgs);
        return "filials-add";
    }
    @PostMapping("/library/filials/save")
    public String saveFilial(Filial filial){
        filialRepository.save(filial);
        return "redirect:/library/filials";
    }
    @GetMapping("/library/filials/edit/{id}")
    public String showEditFilialForm (@PathVariable("id") Long id, Model model) {
        if (!filialRepository.existsById(id)){
            return "redirect:/library/filials";
        }
        Optional<Filial> filial = filialRepository.findById(id);
        ArrayList<Filial> filials = new ArrayList<>();
        filial.ifPresent(filials::add);

  /*      Filial filial = filialRepository.findById(id).get();*/
        List<Org> listOrgs = (List<Org>) orgRepository.findAll();
        model.addAttribute("filial", filial);
        model.addAttribute("listOrgs", listOrgs);
        return "filials-add";
    }
    @GetMapping("/library/filials/delete/{id}")
    public String deleteFilial (@PathVariable("id") Long id, Model model) {
        filialRepository.deleteById(id);
        return "redirect:/library/filials";
    }
}
