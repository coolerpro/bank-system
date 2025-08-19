package com.JuniorJavaDeveloper.banksystem.controllers;

import com.JuniorJavaDeveloper.banksystem.forms.CreditForm;
import com.JuniorJavaDeveloper.banksystem.forms.FormManager;
import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import com.JuniorJavaDeveloper.banksystem.services.creditmanager.CreditManager;
import com.JuniorJavaDeveloper.banksystem.services.impl.BankServiceImpl;
import com.JuniorJavaDeveloper.banksystem.services.impl.ClientServiceImpl;
import com.JuniorJavaDeveloper.banksystem.services.impl.CreditServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(CreditController.class)
class CreditControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreditServiceImpl mainService;
    @MockBean
    private BankServiceImpl bankService;
    @MockBean
    private CreditOfferService creditOfferService;
    @MockBean
    private ClientServiceImpl clientService;
    @MockBean
    private FormManager formManager;
    @MockBean
    private CreditManager creditManager;

    @Test
    void listAllReturnsIndexView() throws Exception {
        CreditForm form = new CreditForm();
        when(formManager.getCreditForm()).thenReturn(form);
        when(mainService.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/credit"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}

