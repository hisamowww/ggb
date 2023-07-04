package com.example.ggb.controllers;

import com.example.ggb.entyties.Mestorog;
import com.example.ggb.repositories.MestorogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MestorogController {

    @Autowired
    private MestorogRepository mestorogRepository;


    @GetMapping("/library/mestorog")
    public String listMestorogs (Model model) {
        List<Mestorog> listMestorogs = (List<Mestorog>) mestorogRepository.findAll();
        model.addAttribute("listMestorogs", listMestorogs);
        return "mestorog";
    }

    @GetMapping("/library/mestorog/new")
    public String showMestorogNewForm (Model model) {
        model.addAttribute("mestorog", new Mestorog());
        return "mestorog-add";
    }
    @PostMapping("/library/mestorog/save")
    public String saveMestorog(Mestorog mestorog){
        mestorogRepository.save(mestorog);
        return "redirect:/library/mestorog";
    }
    @GetMapping("/library/mestorog/edit/{id}")
    public String showEditMestorogForm (@PathVariable("id") Long id, Model model) {
        Mestorog mestorog = mestorogRepository.findById(id).get();
        model.addAttribute("mestorog", mestorog);
        return "mestorog-add";
    }
    @GetMapping("/library/mestorog/delete/{id}")
    public String deleteMestorog (@PathVariable("id") Long id, Model model) {
        mestorogRepository.deleteById(id);
        return "redirect:/library/mestorog";
    }


}
