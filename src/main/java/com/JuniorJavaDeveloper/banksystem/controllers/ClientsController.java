package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.entity.Client;
import com.JuniorJavaDeveloper.banksystem.forms.ClientForm;
import com.JuniorJavaDeveloper.banksystem.forms.FormManager;
import com.JuniorJavaDeveloper.banksystem.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/client")
public class ClientsController {

    private final MainService mainService;
    private final FormManager formManager;

    @Autowired
    public ClientsController(@Qualifier("clientServiceImpl") MainService mainService,
                             FormManager formManager) {
        this.mainService = mainService;
        this.formManager = formManager;
    }

    @GetMapping()
    public String listAll(Model model) {

        ClientForm clientForm = formManager.getClientForm();

        clientForm.setTitle("Список клиентов");
        clientForm.setContent("clientlist");
        clientForm.setClientsList(mainService.findAll());

        model.addAttribute("form", clientForm);

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

        ClientForm clientForm = formManager.getClientForm();

        clientForm.setClient(new Client());
        clientForm.setTitle("Новый клиент");
        clientForm.setContent("clientnew");

        model.addAttribute("form", clientForm);

        return "index";
    }

    @PostMapping()
    public String create(@ModelAttribute("form") ClientForm clientForm) throws Exception {
        mainService.save(clientForm.getClient());
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
