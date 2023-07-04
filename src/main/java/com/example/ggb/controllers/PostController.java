package com.example.ggb.controllers;

import com.example.ggb.entyties.Mestorog;
import com.example.ggb.entyties.Post;
import com.example.ggb.entyties.PostGroup;
import com.example.ggb.repositories.PostGroupRepository;
import com.example.ggb.repositories.PostRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostGroupRepository postGroupRepository;

    @GetMapping("/library/posts")
    public String listPosts (Model model){
        List<Post> listPosts = (List<Post>) postRepository.findAll();
        model.addAttribute("listPosts", listPosts);
        return "posts";
    }
    @GetMapping("/library/posts/new")
    public String showPostNewForm (Model model){
        model.addAttribute("post", new Post());
        List<PostGroup> listPostGroups = (List<PostGroup>) postGroupRepository.findAll();
        model.addAttribute("listPostGroups", listPostGroups);
        return "posts-add";
    }
    @PostMapping("/library/posts/save")
    public String savePost(Post post){
        postRepository.save(post);
        return "redirect:/library/posts";
    }

    @GetMapping("/library/posts/edit/{id}")
    public String showEditPostForm (@PathVariable("id") Long id, Model model) {
        Post post = postRepository.findById(id).get();
        List<PostGroup> listPostGroups = (List<PostGroup>) postGroupRepository.findAll();
        model.addAttribute("listPostGroups", listPostGroups);
        model.addAttribute("post", post);
        return "posts-add";
    }

    @GetMapping("/library/posts/delete/{id}")
    public String deletePost (@PathVariable("id") Long id, Model model) {
        postRepository.deleteById(id);
        return "redirect:/library/posts";
    }
}
