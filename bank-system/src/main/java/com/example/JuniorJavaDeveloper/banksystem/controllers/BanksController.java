package com.example.JuniorJavaDeveloper.banksystem.controllers;

import com.example.JuniorJavaDeveloper.banksystem.models.BankDto;
import com.example.JuniorJavaDeveloper.banksystem.services.BankService;
import com.example.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import com.example.JuniorJavaDeveloper.banksystem.services.CreditService;
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
    public String banks(Model model){
        //получим всех клиентов
        model.addAttribute("banksList", bankService.banksList());

        return "banks/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model){

        // получим одного клиента по id
        BankDto bankDto = bankService.getBank(id);
        model.addAttribute("bank", bankDto);
        model.addAttribute("creditOffersList", creditOfferService.creditOffersList(bankDto));
        model.addAttribute("creditList", creditService.getCredits(bankDto));
        return "banks/show";
    }

    @GetMapping("/new")
    public String newClient(@ModelAttribute("bankNew") BankDto bankNew){
        return "banks/new";
    }

    @PostMapping()
    public String createClient(@ModelAttribute("bankNew") BankDto bankNew, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "banks/new";
        }
        bankService.save(bankNew);
        return "redirect:/banks";
    }

    @GetMapping("/{id}/edit")
    public String editClient(Model model, @PathVariable("id") UUID id){
        model.addAttribute("bankEdit", bankService.getBank(id));
        return "banks/edit";
    }

    @PatchMapping("/{id}")
    public String updateClient(@ModelAttribute("bankEdit") BankDto bankEdit, BindingResult bindingResult, @PathVariable("id") UUID id){

        if (bindingResult.hasErrors()){
            return "banks/edit";
        }
        bankService.update(bankEdit);
        return "redirect:/banks";
    }
    @DeleteMapping("/{id}")
    public String deleteBank(@PathVariable("id") UUID id){

        bankService.delete(id);
        return "redirect:/banks";
    }

}
