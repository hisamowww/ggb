package com.example.ggb.controllers;

import com.example.ggb.entyties.Oborud;
import com.example.ggb.repositories.OborudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OborudController {

    @Autowired
    private OborudRepository oborudRepository;

    @GetMapping("/library/oboruds")
    public String listOboruds (Model model) {
        List<Oborud> listOboruds = (List<Oborud>) oborudRepository.findAll();
        model.addAttribute("listOboruds", listOboruds);
        return "oboruds";
    }
    @GetMapping("/library/oboruds/new")
    public String showOborudNewForm (Model model) {
        model.addAttribute("oborud", new Oborud());
        return "oboruds-add";
    }

    @PostMapping("/library/oboruds/save")
    public String saveOborud(Oborud oborud){
        oborudRepository.save(oborud);
        return "redirect:/library/oboruds";
    }

    @GetMapping("/library/oboruds/edit/{id}")
    public String showEditOborudForm (@PathVariable("id") Long id, Model model) {
        Oborud oborud = oborudRepository.findById(id).get();
        model.addAttribute("oborud", oborud);
        return "oboruds-add";
    }
    @GetMapping("/library/oboruds/delete/{id}")
    public String deleteOborud (@PathVariable("id") Long id, Model model) {
        oborudRepository.deleteById(id);
        return "redirect:/library/oboruds";
    }



}
