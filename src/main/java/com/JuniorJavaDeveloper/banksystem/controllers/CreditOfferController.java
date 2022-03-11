package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.models.BankDto;
import com.JuniorJavaDeveloper.banksystem.models.CreditOfferDto;
import com.JuniorJavaDeveloper.banksystem.services.BankService;
import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/creditoffers")
public class CreditOfferController {

    private final CreditOfferService creditOfferService;
    private final BankService bankService;

    @Autowired
    public CreditOfferController(CreditOfferService creditOfferService, BankService bankService) {
        this.creditOfferService = creditOfferService;
        this.bankService = bankService;
    }


    @GetMapping()
    public String banks(Model model){
        //получим всех
        model.addAttribute("creditOffersList", creditOfferService.creditOffersList());

        return "creditoffers/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model){

        // получим одного клиента по id
        model.addAttribute("creditOffer", creditOfferService.getCreditOffer(id));
        return "creditoffers/show";
    }

    @GetMapping("/new")
    public String newClient(Model model){
        model.addAttribute("creditOfferNew", new CreditOfferDto());

        model.addAttribute("bank", new BankDto());
        model.addAttribute("allBanks", bankService.banksList());
        return "creditoffers/new";
    }

    @PostMapping()
    public String createClient(CreditOfferDto creditOfferNew , BankDto bank, BindingResult bindingResultCredit) throws Exception {

        if (bindingResultCredit.hasErrors()){
            return "creditoffers/new";
        }

        creditOfferNew.setCreditOrganization(bankService.getBank(bank.getId()));
        creditOfferService.save(creditOfferNew);
        return "redirect:/creditoffers";
    }

    @GetMapping("/{id}/edit")
    public String editClient(Model model, @PathVariable("id") UUID id){
        model.addAttribute("creditOfferEdit", creditOfferService.getCreditOffer(id));
        return "creditoffers/edit";
    }

    @PatchMapping("/{id}")
    public String updateClient(@ModelAttribute("creditOfferEdit") CreditOfferDto creditOfferEdit, BindingResult bindingResult, @PathVariable("id") UUID id) throws Exception {

        if (bindingResult.hasErrors()){
            return "creditoffers/edit";
        }
        creditOfferService.update(creditOfferEdit);
        return "redirect:/creditoffers";
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable("id") UUID id){
        creditOfferService.delete(id);
        return "redirect:/creditoffers";
    }
}
