package com.example.ggb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/library")
    private String libraryPage() {
        return "library";
    }
}
