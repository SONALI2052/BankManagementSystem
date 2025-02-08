package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.entity.Account;
import com.main.service.AccountService;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/create-account")
    public String showCreateAccountPage() {
        return "create-account";  
    }

    @PostMapping("/create-account")
    public String createAccount(
        @RequestParam("customerId") Long customerId,
        @RequestParam("customerName") String customerName,
        @RequestParam("accountType") String accountType,
        @RequestParam("balance") double balance,
        Model model
    ) {
        Account account = accountService.createAccount(customerId, customerName, accountType, balance);
        model.addAttribute("account", account);
        return "account-success"; 
    }

    
    @PostMapping("/deposit")
    public String depositAmount(
            @RequestParam("customerId") Long customerId,
            @RequestParam("amount") double amount,
            Model model
    ) {
        Account account = accountService.deposit(customerId, amount);
        model.addAttribute("account", account);
        return "deposit-success"; 
    }
}
