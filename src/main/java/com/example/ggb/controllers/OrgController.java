package com.example.ggb.controllers;

import com.example.ggb.entyties.Org;
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
public class OrgController {
    @Autowired
    private OrgRepository orgRepository;
    @Autowired
    private FilialRepository filialRepository;

    @GetMapping("/library/orgs")
    public String listOrgs (Model model) {
        List<Org> listOrgs = (List<Org>) orgRepository.findAll();
        model.addAttribute("listOrgs", listOrgs);
        return "orgs";
    }
    @GetMapping("/library/orgs/new")
    public String showOrgNewForm (Model model) {
/*        List<Filial> listFilials = (List<Filial>) filialRepository.findAll();*/
        model.addAttribute("org", new Org());
/*        model.addAttribute("listFilials", listFilials);*/
        return "orgs-add";
    }

    @PostMapping("/library/orgs/save")
    public String saveOrg(Org org){
        orgRepository.save(org);
        return "redirect:/library/orgs";
    }
    @GetMapping("/library/orgs/edit/{id}")
    public String showEditOrgForm (@PathVariable("id") Long id, Model model) {
        Org org = orgRepository.findById(id).get();
/*        List<Filial> listFilials = (List<Filial>) filialRepository.findAll();*/
        model.addAttribute("org", org);
/*        model.addAttribute("listFilials", listFilials);*/
        return "orgs-add";
    }
    @GetMapping("/library/orgs/delete/{id}")
    public String deleteOrg (@PathVariable("id") Long id, Model model) {
        orgRepository.deleteById(id);
        return "redirect:/library/orgs";
    }


}
