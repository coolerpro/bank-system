package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.forms.BankForm;
import com.JuniorJavaDeveloper.banksystem.forms.FormManager;
import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import com.JuniorJavaDeveloper.banksystem.services.CreditService;
import com.JuniorJavaDeveloper.banksystem.services.MainService;
import com.JuniorJavaDeveloper.banksystem.services.impl.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/bank")
public class BanksController {

    private final MainService mainService;
    private final CreditOfferService creditOfferService;
    private final CreditService creditService;
    private final FormManager formManager;

    @Autowired
    public BanksController(BankServiceImpl mainService,
                           CreditOfferService creditOfferService,
                           CreditService creditService,
                           FormManager formManager) {
        this.mainService = mainService;
        this.creditOfferService = creditOfferService;
        this.creditService = creditService;
        this.formManager = formManager;
    }

    @GetMapping()
    public String listAll(Model model) {

        BankForm bankForm = formManager.getBankForm();

        bankForm.setTitle("Список банков");
        bankForm.setContent("banklist");
        bankForm.setBankList(mainService.findAll());

        model.addAttribute("form", bankForm);

        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model) {

        Bank bank = (Bank) mainService.findById(id);

        BankForm bankForm = formManager.getBankForm();

        bankForm.setTitle(bank.getName());
        bankForm.setContent("bankshow");
        bankForm.setBank(bank);
        bankForm.setCreditOfferList(creditOfferService.findCreditOffersByBank(bank));
        bankForm.setCreditList(creditService.findCreditsByBank(bank));

        model.addAttribute("form", bankForm);

        return "index";
    }

    @GetMapping("/new")
    public String newElem(Model model) {

        BankForm bankForm = formManager.getBankForm();

        bankForm.setTitle("Создать банк");
        bankForm.setContent("banknew");
        bankForm.setBank(new Bank());

        model.addAttribute("form", bankForm);

        return "index";
    }

    @PostMapping()
    public String create(@ModelAttribute("form") BankForm bankForm) throws Exception {

        mainService.save(bankForm.getBank());
        return "redirect:/bank";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") UUID id) {

        Bank bank = (Bank) mainService.findById(id);

        BankForm bankForm = formManager.getBankForm();

        bankForm.setTitle(bank.getName());
        bankForm.setContent("bankedit");
        bankForm.setBank(bank);
        bankForm.setCreditOfferList(creditOfferService.findCreditOffersByBank(bank));
        bankForm.setCreditList(creditService.findCreditsByBank(bank));

        model.addAttribute("form", bankForm);

        return "index";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("form") BankForm bankForm, @PathVariable("id") UUID id) throws Exception {

        Bank bank = bankForm.getBank();
        bank.setId(id);
        mainService.save(bank);
        return "redirect:/bank";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") UUID id) {
        mainService.delete(id);
        return "redirect:/bank";
    }
}
