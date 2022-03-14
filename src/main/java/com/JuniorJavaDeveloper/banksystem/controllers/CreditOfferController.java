package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.CreditOffer;
import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import com.JuniorJavaDeveloper.banksystem.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/creditoffers")
public class CreditOfferController {

    private final CreditOfferService creditOfferService;
    private final MainService bankService;

    @Autowired
    public CreditOfferController(CreditOfferService creditOfferService, @Qualifier("bankServiceImpl") MainService bankService) {
        this.creditOfferService = creditOfferService;
        this.bankService = bankService;
    }

    @GetMapping()
    public String banks(Model model) {
        model.addAttribute("creditOffersList", creditOfferService.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("creditOffer", creditOfferService.findById(id));
        return "creditoffers/show";
    }

    @GetMapping("/new")
    public String newClient(Model model) {
        model.addAttribute("creditOfferNew", new CreditOffer());
        model.addAttribute("bank", new Bank());
        model.addAttribute("allBanks", bankService.findAll());
        return "creditoffers/new";
    }

    @PostMapping()
    public String createClient(CreditOffer creditOfferNew, Bank bank, BindingResult bindingResultCredit) throws Exception {
        if (bindingResultCredit.hasErrors()) {
            return "creditoffers/new";
        }
        creditOfferNew.setBank((Bank) bankService.findById(bank.getId()));
        creditOfferService.save(creditOfferNew);
        return "redirect:/creditoffers";
    }

    @GetMapping("/{id}/edit")
    public String editClient(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("creditOfferEdit", creditOfferService.findById(id));
        return "creditoffers/edit";
    }

    @PatchMapping("/{id}")
    public String updateClient(@ModelAttribute("creditOfferEdit") CreditOffer creditOfferEdit, BindingResult bindingResult, @PathVariable("id") UUID id) throws Exception {
        if (bindingResult.hasErrors()) {
            return "creditoffers/edit";
        }
        creditOfferService.save(creditOfferEdit);
        return "redirect:/creditoffers";
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable("id") UUID id) {
        creditOfferService.delete(id);
        return "redirect:/creditoffers";
    }
}
