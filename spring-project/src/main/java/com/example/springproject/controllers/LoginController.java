package com.example.springproject.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LoginController {

    @RequestMapping(value = "/login" , method = {RequestMethod.GET, RequestMethod.POST})
    public String displayLoginPage(@RequestParam(required = false) String error, @RequestParam(required = false) String logout,
                               Model model){
        String errorMessage = "";
        if(error != null && error.equals("true")){
            errorMessage = "Failed to login. Username or password is incorrect!";
            model.addAttribute("errorMessage", errorMessage);
        }
        else if(logout != null && logout.equals("true")){
            errorMessage = "Successfully logged out of the application";
            model.addAttribute("errorMessage", errorMessage);
        }
        return "login.html";
    }
}
