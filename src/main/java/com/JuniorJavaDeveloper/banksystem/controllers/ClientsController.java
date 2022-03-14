package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.entity.Client;
import com.JuniorJavaDeveloper.banksystem.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    private final MainService mainService;

    @Autowired
    public ClientsController(@Qualifier("clientServiceImpl") MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping()
    public String clients(Model model) {
        model.addAttribute("clientsList", mainService.findAll());
        return "clients/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("client", mainService.findById(id));
        return "clients/show";
    }

    @GetMapping("/new")
    public String newClient(@ModelAttribute("clientNew") Client clientNew) {
        return "clients/new";
    }

    @PostMapping()
    public String createClient(@ModelAttribute("clientNew") Client clientNew, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "clients/new";
        }
        mainService.save(clientNew);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/edit")
    public String editClient(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("clientEdit", mainService.findById(id));
        return "clients/edit";
    }

    @PatchMapping("/{id}")
    public String updateClient(@ModelAttribute("clientEdit") Client clientEdit, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "clients/edit";
        }
        mainService.save(clientEdit);
        return "redirect:/clients";
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable("id") UUID id) {
        mainService.delete(id);
        return "redirect:/clients";
    }
}
