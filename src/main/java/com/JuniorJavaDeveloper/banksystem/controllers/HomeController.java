package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.forms.FormManager;
import com.JuniorJavaDeveloper.banksystem.forms.HomeForm;
import com.JuniorJavaDeveloper.banksystem.forms.menu.MenuManager;
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
    private final FormManager formManager;


    @Autowired
    public HomeController(CreditOfferService creditOfferService,
                          @Qualifier("bankServiceImpl") MainService bankService,
                          @Qualifier("clientServiceImpl") MainService clientService,
                          CreditService creditService,
                          FormManager formManager) {
        this.creditOfferService = creditOfferService;
        this.bankService = bankService;
        this.clientService = clientService;
        this.creditService = creditService;
        this.formManager = formManager;
    }

    @GetMapping()
    public String banks(Model model) {

        HomeForm homeForm = formManager.getHomeForm();

        homeForm.setBanksList(bankService.findAll());
        homeForm.setClientsList(clientService.findAll());
        homeForm.setCreditOffersList(creditOfferService.findAll());

        model.addAttribute("homeForm", homeForm);

        return "index";
    }
}
