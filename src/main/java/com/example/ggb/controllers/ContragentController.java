package com.example.ggb.controllers;

import com.example.ggb.entyties.Contragent;
import com.example.ggb.entyties.ContragentCategory;
import com.example.ggb.entyties.Org;
import com.example.ggb.repositories.ContragentCategoryRepository;
import com.example.ggb.repositories.ContragentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContragentController {
    @Autowired
    private ContragentCategoryRepository contragentCategoryRepository;
    @Autowired
    private ContragentRepository contragentRepository;


    @GetMapping("/library/contragents")
    public String listContragents (Model model) {
        List<Contragent> listContragents = (List<Contragent>) contragentRepository.findAll();
        model.addAttribute("listContragents", listContragents);
        return "contragents";
    }

    @GetMapping("/library/contragents/new")
    public String showContragentNewForm (Model model) {
        List<ContragentCategory> listContragentCategories = (List<ContragentCategory>) contragentCategoryRepository.findAll();
        model.addAttribute("contragent", new Contragent());
        model.addAttribute("listContragentCategories", listContragentCategories);
        return "contragent-add";
    }
    @PostMapping("/library/contragents/save")
    public String saveContragent(Contragent contragent){
        contragentRepository.save(contragent);
        return "redirect:/library/contragents";
    }
    @GetMapping("/library/contragents/edit/{id}")
    public String showEditContragentForm (@PathVariable("id") Long id, Model model) {
        Contragent contragent = contragentRepository.findById(id).get();
        List<ContragentCategory> listContragentCategories = (List<ContragentCategory>) contragentCategoryRepository.findAll();
        model.addAttribute("contragent", contragent);
        model.addAttribute("listContragentCategories", listContragentCategories);
        return "contragent-add";
    }
    @GetMapping("/library/contragents/delete/{id}")
    public String deleteContragent (@PathVariable("id") Long id, Model model) {
        contragentRepository.deleteById(id);
        return "redirect:/library/contragents";
    }
}
