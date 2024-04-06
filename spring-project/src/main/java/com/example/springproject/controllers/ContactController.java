package com.example.springproject.controllers;

import com.example.springproject.models.Contact;
import com.example.springproject.services.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @RequestMapping(value = "/contact")
    public String displayContactPage(Model model){
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

//    @RequestMapping(value = "/saveMsg" , method = RequestMethod.POST)
//    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
//                                    @RequestParam String email, @RequestParam String subject,
//                                    @RequestParam String message){
//
//        logger.info("Name : " + name);
//        logger.info("Mobile number : " + mobileNum);
//        logger.info("Email : " + email);
//        logger.info("Subject : " + subject);
//        logger.info("Message : " + message);
//        return new ModelAndView("redirect:/contact");
//    }

    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            log.info("Contact form validation failed due to : "+ errors.toString());
            return "contact.html";
        }
        contactService.saveMessage(contact);
        return "redirect:/contact";
    }

    @RequestMapping(value = "/displayMessages", method = RequestMethod.GET)
    public ModelAndView displayMessages(){
        List<Contact> contacts = contactService.displayMessagesByStatus();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("messages");
        modelAndView.addObject("contactMsgs", contacts);
        return modelAndView;
    }
}
