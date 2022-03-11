package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.services.BankService;
import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import com.JuniorJavaDeveloper.banksystem.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/banks")
public class BanksController {

    private final BankService bankService;
    private final CreditOfferService creditOfferService;
    private final CreditService creditService;

    @Autowired
    public BanksController(BankService bankService, CreditOfferService creditOfferService, CreditService creditService) {
        this.bankService = bankService;
        this.creditOfferService = creditOfferService;
        this.creditService = creditService;
    }

    @GetMapping()
    public String banks(Model model) {
        model.addAttribute("banksList", bankService.banksList());
        return "banks/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model) {
        Bank bank = bankService.getBank(id);
        model.addAttribute("bank", bank);
        model.addAttribute("creditOffersList", creditOfferService.creditOffersList(bank));
        model.addAttribute("creditList", creditService.getCredits(bank));
        return "banks/show";
    }

    @GetMapping("/new")
    public String newClient(@ModelAttribute("bankNew") Bank bankNew) {
        return "banks/new";
    }

    @PostMapping()
    public String createClient(@ModelAttribute("bankNew") Bank bankNew, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "banks/new";
        }
        bankService.save(bankNew);
        return "redirect:/banks";
    }

    @GetMapping("/{id}/edit")
    public String editClient(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("bankEdit", bankService.getBank(id));
        return "banks/edit";
    }

    @PatchMapping("/{id}")
    public String updateClient(@ModelAttribute("bankEdit") Bank bankEdit, BindingResult bindingResult, @PathVariable("id") UUID id) {
        if (bindingResult.hasErrors()) {
            return "banks/edit";
        }
        bankService.update(bankEdit);
        return "redirect:/banks";
    }

    @DeleteMapping("/{id}")
    public String deleteBank(@PathVariable("id") UUID id) {
        bankService.delete(id);
        return "redirect:/banks";
    }
}
