package com.juniorjavadeveloper.banksystem.forms;

import com.juniorjavadeveloper.banksystem.entity.Bank;
import com.juniorjavadeveloper.banksystem.entity.Client;
import com.juniorjavadeveloper.banksystem.entity.CreditOffer;

import java.util.List;

public class HomeForm extends Form {

    private List<Bank> bankList;
    private List<Client> clientList;
    private List<CreditOffer> creditOfferList;

    public List<Bank> getBankList() {
        return bankList;
    }

    public void setBankList(List<Bank> bankList) {
        this.bankList = bankList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<CreditOffer> getCreditOfferList() {
        return creditOfferList;
    }

    public void setCreditOfferList(List<CreditOffer> creditOfferList) {
        this.creditOfferList = creditOfferList;
    }
}
