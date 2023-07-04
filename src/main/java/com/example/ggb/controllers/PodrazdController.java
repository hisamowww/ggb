package com.example.ggb.controllers;

import com.example.ggb.entyties.Filial;
import com.example.ggb.entyties.Podrazd;
import com.example.ggb.repositories.FilialRepository;
import com.example.ggb.repositories.PodrazdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PodrazdController {
    @Autowired
    private PodrazdRepository podrazdRepository;
    @Autowired
    private FilialRepository filialRepository;

    @GetMapping("/library/podrazds")
    public String listPodrads (Model model){
        List<Podrazd> listPodrazds = (List<Podrazd>) podrazdRepository.findAll();
        model.addAttribute("listPodrazds",listPodrazds);
        return "podrazds";
    }

    @GetMapping("/library/podrazds/new")
    public String showPodrazdNewForm (Model model) {
        List<Filial> listFilials = (List<Filial>) filialRepository.findAll();
        model.addAttribute("podrazd", new Podrazd());
        model.addAttribute("listFilials", listFilials);
        return "podrazds-add";
    }

    @PostMapping("/library/podrazds/save")
    public String savePodrazd(Podrazd podrazd){
        podrazdRepository.save(podrazd);
        return "redirect:/library/podrazds";
    }

    @GetMapping("/library/podrazds/edit/{id}")
    public String showEditPodrazdForm (@PathVariable("id") Long id, Model model) {
        Podrazd podrazd = podrazdRepository.findById(id).get();
        List<Filial> listFilials = (List<Filial>) filialRepository.findAll();
        model.addAttribute("podrazd", podrazd);
        model.addAttribute("listFilials", listFilials);
        return "podrazds-add";
    }
    @GetMapping("/library/podrazds/delete/{id}")
    public String deletePodrazd (@PathVariable("id") Long id, Model model) {
        podrazdRepository.deleteById(id);
        return "redirect:/library/podrazds";
    }
}
