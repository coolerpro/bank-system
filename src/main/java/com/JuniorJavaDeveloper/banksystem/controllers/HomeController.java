package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.Client;
import com.JuniorJavaDeveloper.banksystem.forms.FormManager;
import com.JuniorJavaDeveloper.banksystem.forms.HomeForm;
import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import com.JuniorJavaDeveloper.banksystem.services.CreditService;
import com.JuniorJavaDeveloper.banksystem.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    private final CreditOfferService creditOfferService;
    private final MainService<Bank> bankService;
    private final MainService<Client> clientService;
    private final CreditService creditService;
    private final FormManager formManager;


    @Autowired
    public HomeController(CreditOfferService creditOfferService,
                          MainService<Bank> bankService,
                          MainService<Client> clientService,
                          CreditService creditService,
                          FormManager formManager) {
        this.creditOfferService = creditOfferService;
        this.bankService = bankService;
        this.clientService = clientService;
        this.creditService = creditService;
        this.formManager = formManager;
    }

    @GetMapping()
    public String listAll(Model model) {

        HomeForm homeForm = formManager.getHomeForm();

        homeForm.setTitle("Работа с кредитами");
        homeForm.setContent("contentindex");

        homeForm.setBankList(bankService.findAll());
        homeForm.setClientList(clientService.findAll());
        homeForm.setCreditOfferList(creditOfferService.findAll());

        model.addAttribute("form", homeForm);

        return "index";
    }
}
