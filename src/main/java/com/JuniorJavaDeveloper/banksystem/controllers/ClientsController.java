package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.models.entity.Client;
import com.JuniorJavaDeveloper.banksystem.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    private final ClientService clientService;

    @Autowired
    public ClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public String clients(Model model) {
        model.addAttribute("clientsList", clientService.clientsList());
        return "clients/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("client", clientService.getClient(id));
        return "clients/show";
    }

    @GetMapping("/new")
    public String newClient(@ModelAttribute("clientNew") Client clientNew) {
        return "clients/new";
    }

    @PostMapping()
    public String createClient(@ModelAttribute("clientNew") Client clientNew, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "clients/new";
        }
        clientService.save(clientNew);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/edit")
    public String editClient(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("clientEdit", clientService.getClient(id));
        return "clients/edit";
    }

    @PatchMapping("/{id}")
    public String updateClient(@ModelAttribute("clientEdit") Client clientEdit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "clients/edit";
        }
        clientService.update(clientEdit);
        return "redirect:/clients";
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable("id") UUID id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
}
