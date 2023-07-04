package com.example.ggb.controllers;

import com.example.ggb.entyties.ContragentCategory;
import com.example.ggb.entyties.Org;
import com.example.ggb.repositories.ContragentCategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContragentCategoryController {

    private ContragentCategoryRepository contragentCategoryRepository;

    public ContragentCategoryController(ContragentCategoryRepository contragentCategoryRepository) {
        this.contragentCategoryRepository = contragentCategoryRepository;
    }

    @GetMapping("/library/contragentCategory")
    public String listContragentCategories (Model model) {
        List<ContragentCategory> listContragentCategories = (List<ContragentCategory>) contragentCategoryRepository.findAll();
        model.addAttribute("listContragentCategories", listContragentCategories);
        return "contragentCategory";
    }

    @GetMapping("/library/contragentCategory/new")
    public String showContragentCategoryNewForm (Model model) {
        model.addAttribute("contragentCategory", new ContragentCategory());
        return "contragentCategory-add";
    }
    @PostMapping("/library/contragentCategory/save")
    public String saveContragentCategory(ContragentCategory contragentCategory){
        contragentCategoryRepository.save(contragentCategory);
        return "redirect:/library/contragentCategory";
    }
    @GetMapping("/library/contragentCategory/edit/{id}")
    public String showEditContragentCategoryForm (@PathVariable("id") Long id, Model model) {
        ContragentCategory contragentCategory = contragentCategoryRepository.findById(id).get();
        model.addAttribute("contragentCategory", contragentCategory);
        return "contragentCategory-add";
    }
    @GetMapping("/library/contragentCategory/delete/{id}")
    public String deleteContragentCategory (@PathVariable("id") Long id, Model model) {
        contragentCategoryRepository.deleteById(id);
        return "redirect:/library/contragentCategory";
    }
}
