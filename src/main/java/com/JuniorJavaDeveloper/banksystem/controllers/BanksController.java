package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import com.JuniorJavaDeveloper.banksystem.services.CreditService;
import com.JuniorJavaDeveloper.banksystem.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/bank")
public class BanksController {

    private final MainService mainService;
    private final CreditOfferService creditOfferService;
    private final CreditService creditService;

    @Autowired
    public BanksController(@Qualifier("bankServiceImpl") MainService mainService, CreditOfferService creditOfferService, CreditService creditService) {
        this.mainService = mainService;
        this.creditOfferService = creditOfferService;
        this.creditService = creditService;
    }

    @GetMapping()
    public String banks(Model model) {
        model.addAttribute("banksList", mainService.findAll());
        return "bank/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model) {
        Bank bank = (Bank) mainService.findById(id);
        model.addAttribute("bank", bank);
        model.addAttribute("creditOffersList", creditOfferService.findCreditOffersByBank(bank));
        model.addAttribute("creditList", creditService.findCreditsByBank(bank));
        return "bank/show";
    }

    @GetMapping("/new")
    public String newClient(@ModelAttribute("bankNew") Bank bankNew) {
        return "bank/new";
    }

    @PostMapping()
    public String createClient(@ModelAttribute("bankNew") Bank bankNew, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "bank/new";
        }
        mainService.save(bankNew);
        return "redirect:/bank";
    }

    @GetMapping("/{id}/edit")
    public String editClient(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("bankEdit", mainService.findById(id));
        return "bank/edit";
    }

    @PatchMapping("/{id}")
    public String updateClient(@ModelAttribute("bankEdit") Bank bankEdit, BindingResult bindingResult, @PathVariable("id") UUID id) throws Exception {
        if (bindingResult.hasErrors()) {
            return "bank/edit";
        }
        mainService.save(bankEdit);
        return "redirect:/bank";
    }

    @DeleteMapping("/{id}")
    public String deleteBank(@PathVariable("id") UUID id) {
        mainService.delete(id);
        return "redirect:/bank";
    }
}
