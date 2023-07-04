package com.example.ggb.controllers;

import com.example.ggb.entyties.*;
import com.example.ggb.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfWorkDocController {
    @Autowired
    private WorkRepository workRepository;
    @Autowired
    private ContragentRepository contragentRepository;
    @Autowired
    private ContragentObjectRepository contragentObjectRepository;
    @Autowired
    private DogovorRepository dogovorRepository;
    @Autowired
    private ProfWorkDocRepository profWorkDocRepository;
    @Autowired
    private SotrudRepository sotrudRepository;

    @GetMapping("/library/profWorkDocs")
    public String lisProfWorkDocs (Model model){
        List<ProfWorkDoc> listProfWorkDocs = (List<ProfWorkDoc>) profWorkDocRepository.findAll();
        model.addAttribute("listProfWorkDocs", listProfWorkDocs);
        return "profWorkDocs";
    }
    @GetMapping("/library/profWorkDocs/new")
    public String showProfWorkDocNewForm (Model model){
        model.addAttribute("profWorkDoc", new ProfWorkDoc());
        List<Work> listWorks = (List<Work>) workRepository.findAll();
        List<Contragent> listContragents = (List<Contragent>) contragentRepository.findAll();
        List<ContragentObject> listContragentObjects = (List<ContragentObject>) contragentObjectRepository.findAll();
        List<Dogovor> listDogovors = (List<Dogovor>) dogovorRepository.findAll();
        List<Sotrud> listSotruds = (List<Sotrud>) sotrudRepository.findAll();
        model.addAttribute("listWorks", listWorks);
        model.addAttribute("listContragents", listContragents);
        model.addAttribute("listContragentObjects", listContragentObjects);
        model.addAttribute("listDogovors", listDogovors);
        model.addAttribute("listSotruds", listSotruds);
        return "profWorkDocs-add";
    }
    @PostMapping("/library/profWorkDocs/save")
    public String saveProfWorkDoc(ProfWorkDoc profWorkDoc){
        profWorkDocRepository.save(profWorkDoc);
        return "redirect:/library/profWorkDocs";
    }
    @GetMapping("/library/profWorkDocs/edit/{id}")
    public String showEditProfWorkDocForm (@PathVariable("id") Long id, Model model) {
        ProfWorkDoc profWorkDoc = profWorkDocRepository.findById(id).get();
        model.addAttribute("profWorkDoc", profWorkDoc);
        List<Work> listWorks = (List<Work>) workRepository.findAll();
        List<Contragent> listContragents = (List<Contragent>) contragentRepository.findAll();
        List<ContragentObject> listContragentObjects = (List<ContragentObject>) contragentObjectRepository.findAll();
        List<Dogovor> listDogovors = (List<Dogovor>) dogovorRepository.findAll();
        List<Sotrud> listSotruds = (List<Sotrud>) sotrudRepository.findAll();
        model.addAttribute("listWorks", listWorks);
        model.addAttribute("listContragents", listContragents);
        model.addAttribute("listContragentObjects", listContragentObjects);
        model.addAttribute("listDogovors", listDogovors);
        model.addAttribute("listSotruds", listSotruds);
        return "profWorkDocs-add";
    }
    @GetMapping("/library/profWorkDocs/delete/{id}")
    public String deleteProfWorkDoc (@PathVariable("id") Long id, Model model) {
        profWorkDocRepository.deleteById(id);
        return "redirect:/library/profWorkDocs";
    }

}
