package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.Client;
import com.JuniorJavaDeveloper.banksystem.entity.Credit;
import com.JuniorJavaDeveloper.banksystem.entity.CreditOffer;
import com.JuniorJavaDeveloper.banksystem.forms.ClientForm;
import com.JuniorJavaDeveloper.banksystem.forms.CreditForm;
import com.JuniorJavaDeveloper.banksystem.forms.FormManager;
import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import com.JuniorJavaDeveloper.banksystem.services.MainService;
import com.JuniorJavaDeveloper.banksystem.services.creditmanager.CreditManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/credit")
public class CreditController {

    private final MainService mainService;
    private final FormManager formManager;
    private final MainService bankService;
    private final CreditOfferService creditOfferService;
    private final MainService clientService;
    private final CreditManager creditManager;

    @Autowired
    public CreditController(@Qualifier("creditServiceImpl") MainService mainService,
                            @Qualifier("bankServiceImpl") MainService bankService,
                            @Qualifier("creditOfferServiceImpl") CreditOfferService creditOfferService,
                            @Qualifier("clientServiceImpl") MainService clientService,
                            FormManager formManager,
                            CreditManager creditManager) {
        this.mainService = mainService;
        this.formManager = formManager;
        this.bankService = bankService;
        this.creditOfferService = creditOfferService;
        this.clientService = clientService;
        this.creditManager = creditManager;
    }

    @GetMapping()
    public String listAll(Model model) {

        CreditForm creditForm = formManager.getCreditForm();

        creditForm.setTitle("Список всех кредитов");
        creditForm.setContent("creditlist");
        creditForm.setCreditList(mainService.findAll());

        model.addAttribute("form", creditForm);

        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model) {

        ClientForm clientForm = formManager.getClientForm();

        Client client = (Client) mainService.findById(id);

        clientForm.setClient(client);
        clientForm.setTitle(client.getFirstName() + " " + client.getLastName());
        clientForm.setContent("clientshow");

        model.addAttribute("form", clientForm);

        return "index";
    }

    @GetMapping("/new")
    public String newElem(Model model) {

        CreditForm creditForm = formManager.getCreditForm();

        creditForm.setTitle("Новый кредит");
        creditForm.setContent("creditnewbefor");
        creditForm.setBankList(bankService.findAll());
        creditForm.setClientList(clientService.findAll());
        creditForm.setCreditOfferList(creditOfferService.findAll());
        creditForm.setCredit(new Credit());

        model.addAttribute("form", creditForm);

        return "index";
    }

    @PostMapping("/calculation")
    public String calculation(@ModelAttribute("form") CreditForm Form, Model model){



        Bank bank = (Bank) bankService.findById(Form.getBankId());
        Client client = (Client) clientService.findById(Form.getClientId());
        CreditOffer creditOffer = creditOfferService.findById(Form.getCreditOfferId());

        Credit credit = Form.getCredit();
        credit.setBank(bank);
        credit.setClient(client);
        credit.setCreditOffer(creditOffer);

        creditManager.calculateCredit(credit, Form.getDateFirstPayment(), Form.getCountMonth());

        CreditForm creditForm = formManager.getCreditForm();

        creditForm.setTitle("Новый кредит, рассчет");
        creditForm.setContent("creditnew");

        creditForm.setCredit(credit);
        creditForm.setDateFirstPayment(credit.getPaymentSchedule().getDateFirstPayment());
        creditForm.setDateEndPayment(credit.getPaymentSchedule().getDateEndPayment());
        creditForm.setCountMonth(credit.getPaymentSchedule().getPaymentMonths().size());

        creditForm.setSum(credit.getSum());
        creditForm.setSumBody(credit.getSumBody());
        creditForm.setSumPercent(credit.getSumPercent());

        creditForm.setPaymentMonths(credit.getPaymentSchedule().getPaymentMonths());

        model.addAttribute("form", creditForm);

        return "index";
    }

    @PostMapping()
    public String create(@ModelAttribute("form") CreditForm creditForm) throws Exception {
        mainService.save(creditForm.getCredit());
        return "redirect:/client";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") UUID id) {

        ClientForm clientForm = formManager.getClientForm();

        Client client = (Client) mainService.findById(id);

        clientForm.setClient(client);
        clientForm.setTitle(client.getFirstName() + " " + client.getLastName());
        clientForm.setContent("clientedit");

        model.addAttribute("form", clientForm);

        return "index";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("form") ClientForm clientForm, @PathVariable("id") UUID id) throws Exception {
        Client client = clientForm.getClient();
        client.setId(id);
        mainService.save(client);
        return "redirect:/client";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") UUID id) {
        mainService.delete(id);
        return "redirect:/client";
    }
}
