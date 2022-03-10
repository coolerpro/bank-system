package com.example.JuniorJavaDeveloper.banksystem.controllers;

import com.example.JuniorJavaDeveloper.banksystem.services.BankService;
import com.example.JuniorJavaDeveloper.banksystem.services.ClientService;
import com.example.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class FirstController {

    private final CreditOfferService creditOfferService;
    private final BankService bankService;
    private final ClientService clientService;

    @Autowired
    public FirstController(CreditOfferService creditOfferService, BankService bankService, ClientService clientService) {
        this.creditOfferService = creditOfferService;
        this.bankService = bankService;
        this.clientService = clientService;
    }

    @GetMapping()
    public String banks(Model model){
        //получим всех

        model.addAttribute("banksList", bankService.banksList());
        model.addAttribute("clientsList", clientService.clientsList());
        model.addAttribute("creditOffersList", creditOfferService.creditOffersList());

        return "index";
    }
}
