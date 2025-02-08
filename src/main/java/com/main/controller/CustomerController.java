package com.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class CustomerController {

    @RequestMapping("/")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerCustomer(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("email") String email,
                                   @RequestParam("state") String state,
                                   @RequestParam("city") String city,
                                   @RequestParam("branch") String branch,
                                   @RequestParam("phoneNumber") String phoneNumber,
                                   @RequestParam("address") String address,
                                   Model model) {
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("email", email);
        model.addAttribute("state", state);
        model.addAttribute("city", city);
        model.addAttribute("branch", branch);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("address", address);

      
        return "registration-success"; 
    }
}
