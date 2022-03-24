package com.JuniorJavaDeveloper.banksystem.forms;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.Client;
import com.JuniorJavaDeveloper.banksystem.entity.CreditOffer;
import com.JuniorJavaDeveloper.banksystem.forms.menu.MenuForm;

import java.util.List;

public class HomeForm extends Form {

    private List<Bank> banksList;
    private List<Client> clientsList;
    private List<CreditOffer> creditOffersList;

    public List<Bank> getBanksList() {
        return banksList;
    }

    public void setBanksList(List<Bank> banksList) {
        this.banksList = banksList;
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public List<CreditOffer> getCreditOffersList() {
        return creditOffersList;
    }

    public void setCreditOffersList(List<CreditOffer> creditOffersList) {
        this.creditOffersList = creditOffersList;
    }
}
