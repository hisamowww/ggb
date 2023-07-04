package com.example.ggb.controllers;

import com.example.ggb.entyties.Org;
import com.example.ggb.entyties.PostGroup;
import com.example.ggb.repositories.PostGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostGroupController {

    @Autowired
    private PostGroupRepository postGroupRepository;

    @GetMapping("/library/postGroups")
    public String listPostGroups (Model model) {
        List<PostGroup> listPostGroups = (List<PostGroup>) postGroupRepository.findAll();
        model.addAttribute("listPostGroups", listPostGroups);
        return "postGroups";
    }
    @GetMapping("/library/postGroups/new")
    public String showPostGroupNewForm (Model model) {
        model.addAttribute("postGroup", new PostGroup());
        return "postGroups-add";
    }

    @PostMapping("/library/postGroups/save")
    public String savePostGroup(PostGroup postGroup){
        postGroupRepository.save(postGroup);
        return "redirect:/library/postGroups";
    }
    @GetMapping("/library/postGroups/edit/{id}")
    public String showEditPostGroupForm (@PathVariable("id") Long id, Model model) {
        PostGroup postGroup = postGroupRepository.findById(id).get();
        model.addAttribute("postGroup", postGroup);
        return "postGroups-add";
    }
    @GetMapping("/library/postGroups/delete/{id}")
    public String deletePostGroup (@PathVariable("id") Long id, Model model) {
        postGroupRepository.deleteById(id);
        return "redirect:/library/postGroups";
    }

}
