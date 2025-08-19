package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.entity.*;
import com.JuniorJavaDeveloper.banksystem.forms.CreditForm;
import com.JuniorJavaDeveloper.banksystem.forms.FormManager;
import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import com.JuniorJavaDeveloper.banksystem.services.MainService;
import com.JuniorJavaDeveloper.banksystem.services.creditmanager.CreditManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/credit")
public class CreditController {

    private final MainService<Credit> mainService;
    private final FormManager formManager;
    private final MainService<Bank> bankService;
    private final CreditOfferService creditOfferService;
    private final MainService<Client> clientService;
    private final CreditManager creditManager;

    @Autowired
    public CreditController(MainService<Credit> mainService,
                            MainService<Bank> bankService,
                            CreditOfferService creditOfferService,
                            MainService<Client> clientService,
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

        CreditForm creditForm = formManager.getCreditForm();

        Credit credit = mainService.findById(id);

        creditForm.setCredit(credit);
        creditForm.setTitle("Кредит");
        creditForm.setContent("creditshow");

        model.addAttribute("form", creditForm);

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

    @GetMapping("/bank/{id}/new")
    public String newElemBank(Model model, @PathVariable("id") UUID id) {

        Credit credit = new Credit();
        Bank bank = bankService.findById(id);
        credit.setBank(bank);

        CreditForm creditForm = formManager.getCreditForm();

        creditForm.setTitle("Новый кредит");
        creditForm.setContent("creditnewbefor");
        creditForm.setBankList(bankService.findAll());
        creditForm.setClientList(clientService.findAll());
        creditForm.setCreditOfferList(creditOfferService.findAll());
        creditForm.setCredit(credit);

        model.addAttribute("form", creditForm);

        return "index";
    }

    @GetMapping("/client/{id}/new")
    public String newElemClient(Model model, @PathVariable("id") UUID id) {

        CreditForm creditForm = formManager.getCreditForm();

        Credit credit = new Credit();
        Client client = clientService.findById(id);
        credit.setClient(client);

        creditForm.setTitle("Новый кредит");
        creditForm.setContent("creditnewbefor");
        creditForm.setBankList(bankService.findAll());
        creditForm.setClientList(clientService.findAll());
        creditForm.setCreditOfferList(creditOfferService.findAll());
        creditForm.setCredit(credit);

        model.addAttribute("form", creditForm);

        return "index";
    }

    @PostMapping("/calculation")
    public String calculation(@ModelAttribute("form") CreditForm Form, Model model) {

        Credit credit = getCreditByForm(Form);

        creditManager.calculateCredit(credit, Form.getDateFirstPayment(), Form.getCountMonth());

        CreditForm creditForm = formManager.getCreditForm();

        creditForm.setTitle("Новый кредит, рассчет");
        creditForm.setContent("creditnew");

        creditForm.setCredit(credit);
        creditForm.setDateFirstPayment(credit.getPaymentSchedule().getDateFirstPayment());
        creditForm.setDateEndPayment(credit.getPaymentSchedule().getDateEndPayment());
        creditForm.setCountMonth(credit.getPaymentSchedule().getPaymentMonths().size());

        creditForm.setPaymentMonths(credit.getPaymentSchedule().getPaymentMonths());

        model.addAttribute("form", creditForm);

        return "index";
    }

    @PostMapping()
    public String create(@ModelAttribute("form") CreditForm Form) throws Exception {
        Credit credit = getCreditByForm(Form);

        mainService.save(credit);
        return "redirect:/credit";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") UUID id) {

        CreditForm creditForm = formManager.getCreditForm();

        Credit credit = mainService.findById(id);

        creditForm.setCredit(credit);
        creditForm.setTitle("Кредит");
        creditForm.setContent("creditedit");

        model.addAttribute("form", creditForm);

        return "index";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("form") CreditForm creditForm, @PathVariable("id") UUID id) throws Exception {
        Credit credit = getCreditByForm(creditForm);
        credit.setId(id);
        mainService.save(credit);
        return "redirect:/credit";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") UUID id) {

        mainService.delete(id);
        return "redirect:/credit";
    }

    private Credit getCreditByForm(CreditForm Form) {
        Bank bank = bankService.findById(Form.getBankId());
        Client client = clientService.findById(Form.getClientId());
        CreditOffer creditOffer = creditOfferService.findById(Form.getCreditOfferId());

        Credit credit = Form.getCredit();
        credit.setBank(bank);
        credit.setClient(client);
        credit.setCreditOffer(creditOffer);

        if (Form.getPaymentMonths() != null) {

            PaymentSchedule paymentSchedule = new PaymentSchedule();
            Form.getPaymentMonths().stream().map((paymentMonth) -> {
                paymentMonth.setPaymentSchedule(paymentSchedule);
                return paymentMonth;
            }).collect(Collectors.toList());
            paymentSchedule.setDateFirstPayment(Form.getDateFirstPayment());
            paymentSchedule.setDateEndPayment(Form.getDateEndPayment());
            paymentSchedule.setPaymentMonths(Form.getPaymentMonths());
            credit.setPaymentSchedule(paymentSchedule);
        }

        return credit;
    }
}
