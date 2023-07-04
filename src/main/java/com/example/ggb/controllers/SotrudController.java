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
public class SotrudController {
    @Autowired
    private OrgRepository orgRepository;
    @Autowired
    private FilialRepository filialRepository;
    @Autowired
    private PodrazdRepository podrazdRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private SotrudRepository sotrudRepository;

    @GetMapping("/library/sotruds")
    public String listSotruds (Model model){
        List<Sotrud> listSotruds = (List<Sotrud>) sotrudRepository.findAll();
        model.addAttribute("listSotruds", listSotruds);
        return "sotruds";
    }
    @GetMapping("/library/sotruds/new")
    public String showSotrudNewForm (Model model){
        model.addAttribute("sotrud", new Sotrud());
        List<Org> listOrgs = (List<Org>) orgRepository.findAll();
        List<Filial> listFilials = (List<Filial>) filialRepository.findAll();
        List<Podrazd> listPodrazds = (List<Podrazd>) podrazdRepository.findAll();
        List<Post> listPosts = (List<Post>) postRepository.findAll();
        model.addAttribute("listOrgs", listOrgs);
        model.addAttribute("listFilials", listFilials);
        model.addAttribute("listPodrazds", listPodrazds);
        model.addAttribute("listPosts", listPosts);
        return "sotruds-add";
    }
    @PostMapping("/library/sotruds/save")
    public String saveSotrud(Sotrud sotrud){
        sotrudRepository.save(sotrud);
        return "redirect:/library/sotruds";
    }
    @GetMapping("/library/sotruds/edit/{id}")
    public String showEditSotrudForm (@PathVariable("id") Long id, Model model) {
        Sotrud sotrud = sotrudRepository.findById(id).get();
         model.addAttribute("sotrud", sotrud);
        List<Org> listOrgs = (List<Org>) orgRepository.findAll();
        List<Filial> listFilials = (List<Filial>) filialRepository.findAll();
        List<Podrazd> listPodrazds = (List<Podrazd>) podrazdRepository.findAll();
        List<Post> listPosts = (List<Post>) postRepository.findAll();
        model.addAttribute("listOrgs", listOrgs);
        model.addAttribute("listFilials", listFilials);
        model.addAttribute("listPodrazds", listPodrazds);
        model.addAttribute("listPosts", listPosts);
        return "sotruds-add";
    }
    @GetMapping("/library/sotruds/delete/{id}")
    public String deleteSotrud (@PathVariable("id") Long id, Model model) {
        sotrudRepository.deleteById(id);
        return "redirect:/library/sotruds";
    }
}
