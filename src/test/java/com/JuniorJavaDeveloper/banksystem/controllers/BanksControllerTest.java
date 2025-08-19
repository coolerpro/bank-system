package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.forms.BankForm;
import com.JuniorJavaDeveloper.banksystem.forms.FormManager;
import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import com.JuniorJavaDeveloper.banksystem.services.CreditService;
import com.JuniorJavaDeveloper.banksystem.services.impl.BankServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BanksController.class)
class BanksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BankServiceImpl mainService;
    @MockBean
    private CreditOfferService creditOfferService;
    @MockBean
    private CreditService creditService;
    @MockBean
    private FormManager formManager;

    @Test
    void listAllReturnsIndexView() throws Exception {
        BankForm form = new BankForm();
        when(formManager.getBankForm()).thenReturn(form);
        when(mainService.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/bank"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

        verify(mainService).findAll();
    }

    @Test
    void createBankRedirectsOnSuccess() throws Exception {
        BankForm form = new BankForm();
        form.setBank(new Bank());

        mockMvc.perform(post("/bank").flashAttr("form", form))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/bank"));

        verify(mainService).save(any(Bank.class));
    }

    @Test
    void createBankReturnsServerErrorOnException() throws Exception {
        BankForm form = new BankForm();
        form.setBank(new Bank());
        doThrow(new Exception("fail")).when(mainService).save(any(Bank.class));

        mockMvc.perform(post("/bank").flashAttr("form", form))
                .andExpect(status().is5xxServerError());
    }
}

