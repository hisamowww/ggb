package com.example.ggb.controllers;

import com.example.ggb.entyties.Mestorog;
import com.example.ggb.entyties.Work;
import com.example.ggb.repositories.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WorkController {

    @Autowired
    private WorkRepository workRepository;


    @GetMapping("/library/works")
    public String listWorks (Model model) {
        List<Work> listWorks = (List<Work>) workRepository.findAll();
        model.addAttribute("listWorks", listWorks);
        return "works";
    }

    @GetMapping("/library/works/new")
    public String showWorkNewForm (Model model) {
        model.addAttribute("work", new Work());
        return "works-add";
    }
    @PostMapping("/library/works/save")
    public String saveWork(Work work){
        workRepository.save(work);
        return "redirect:/library/works";
    }
    @GetMapping("/library/works/edit/{id}")
    public String showEditWorkForm (@PathVariable("id") Long id, Model model) {
        Work work = workRepository.findById(id).get();
        model.addAttribute("work", work);
        return "works-add";
    }
    @GetMapping("/library/works/delete/{id}")
    public String deleteWork (@PathVariable("id") Long id, Model model) {
        workRepository.deleteById(id);
        return "redirect:/library/works";
    }
}
