package com.example.springproject.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class HomeController {

    @RequestMapping(value = {"", "/", "home"})
    public String displayHomePage(Model model){
        model.addAttribute("username", "John Smith");
        return "home.html";
    }

}
