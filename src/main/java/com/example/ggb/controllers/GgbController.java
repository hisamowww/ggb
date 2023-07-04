package com.example.ggb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GgbController {

    @GetMapping("/")
    private String getGgbApplication(){
        return "index";
    }

    @GetMapping("/admin")
    private String getAdminPanel(){
        return "admin";
    }

    @GetMapping("/loginPage")
    private String getLoginPage(){
        return "loginPage";
    }
}
