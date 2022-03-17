package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import com.JuniorJavaDeveloper.banksystem.services.CreditService;
import com.JuniorJavaDeveloper.banksystem.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    private final CreditOfferService creditOfferService;
    private final MainService bankService;
    private final MainService clientService;
    private final CreditService creditService;

    @Autowired
    public HomeController(CreditOfferService creditOfferService, @Qualifier("bankServiceImpl") MainService bankService, @Qualifier("clientServiceImpl") MainService clientService, CreditService creditService) {
        this.creditOfferService = creditOfferService;
        this.bankService = bankService;
        this.clientService = clientService;
        this.creditService = creditService;
    }

    @GetMapping()
    public String banks(Model model) {

        model.addAttribute("banksList", bankService.findAll());
        model.addAttribute("clientsList", clientService.findAll());
        model.addAttribute("creditOffersList", creditOfferService.findAll());
        return "index";
    }
}
