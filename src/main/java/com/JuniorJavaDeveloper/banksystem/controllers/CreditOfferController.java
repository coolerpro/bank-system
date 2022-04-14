package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.CreditOffer;
import com.JuniorJavaDeveloper.banksystem.forms.CreditOfferForm;
import com.JuniorJavaDeveloper.banksystem.forms.FormManager;
import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import com.JuniorJavaDeveloper.banksystem.services.MainService;
import com.JuniorJavaDeveloper.banksystem.services.impl.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/creditoffer")
public class CreditOfferController {

    private final CreditOfferService creditOfferService;
    private final MainService bankService;
    private final FormManager formManager;

    @Autowired
    public CreditOfferController(CreditOfferService creditOfferService,
                                 BankServiceImpl bankService,
                                 FormManager formManager) {
        this.creditOfferService = creditOfferService;
        this.bankService = bankService;
        this.formManager = formManager;
    }

    @GetMapping()
    public String listAll(Model model) {

        CreditOfferForm creditOffereForm = formManager.getCreditOfferForm();

        creditOffereForm.setTitle("Список кредитных предложений");
        creditOffereForm.setContent("creditofferlist");
        creditOffereForm.setCreditOfferList(creditOfferService.findAll());

        model.addAttribute("form", creditOffereForm);

        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model) {

        CreditOfferForm creditOfferForm = formManager.getCreditOfferForm();

        CreditOffer creditOffer = creditOfferService.findById(id);

        creditOfferForm.setTitle("Кредитное предложение " +creditOffer.getBank());
        creditOfferForm.setContent("creditoffershow");
        creditOfferForm.setCreditOffer(creditOffer);

        model.addAttribute("form", creditOfferForm);

        return "index";
    }

    @GetMapping("/new")
    public String newElem(Model model) {

        CreditOfferForm creditOfferForm = formManager.getCreditOfferForm();

        creditOfferForm.setTitle("Новое кредитное предложение");
        creditOfferForm.setContent("creditoffernew");
        creditOfferForm.setCreditOffer(new CreditOffer());
        creditOfferForm.setBankList(bankService.findAll());

        model.addAttribute("form", creditOfferForm);

        return "index";
    }
    @GetMapping("/bank/{id}/new")
    public String newElemByBank(Model model, @PathVariable("id") UUID id) {

        CreditOfferForm creditOfferForm = formManager.getCreditOfferForm();

        Bank bank = (Bank) bankService.findById(id);
        CreditOffer creditOffer = new CreditOffer();
        creditOffer.setBank(bank);

        creditOfferForm.setTitle("Новое кредитное предложение");
        creditOfferForm.setContent("creditoffernew");
        creditOfferForm.setCreditOffer(creditOffer);
        creditOfferForm.setBankList(bankService.findAll());

        model.addAttribute("form", creditOfferForm);

        return "index";
    }

    @PostMapping()
    public String create(@ModelAttribute("form") CreditOfferForm creditOfferForm) throws Exception {

        CreditOffer creditOffer = creditOfferForm.getCreditOffer();
        Bank bank = (Bank) bankService.findById(creditOfferForm.getBankId());
        creditOffer.setBank(bank);
        creditOfferService.save(creditOffer);

        return "redirect:/creditoffer";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") UUID id) {

        CreditOfferForm creditOfferForm = formManager.getCreditOfferForm();

        CreditOffer creditOffer = creditOfferService.findById(id);

        creditOfferForm.setTitle("Кредитное предложение " +creditOffer.getBank());
        creditOfferForm.setContent("creditofferedit");
        creditOfferForm.setCreditOffer(creditOffer);
        creditOfferForm.setBankId(creditOffer.getBank().getId());

        model.addAttribute("form", creditOfferForm);

        return "index";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("form") CreditOfferForm creditOfferForm, @PathVariable("id") UUID id) throws Exception {

        CreditOffer creditOffer = creditOfferForm.getCreditOffer();
        Bank bank = (Bank) bankService.findById(creditOfferForm.getBankId());
        creditOffer.setBank(bank);
        creditOffer.setId(id);
        creditOfferService.save(creditOffer);
        return "redirect:/creditoffer";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") UUID id) {
        creditOfferService.delete(id);
        return "redirect:/creditoffer";
    }
}
