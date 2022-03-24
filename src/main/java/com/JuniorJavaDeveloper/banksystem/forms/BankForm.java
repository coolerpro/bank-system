package com.JuniorJavaDeveloper.banksystem.forms;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.Credit;
import com.JuniorJavaDeveloper.banksystem.entity.CreditOffer;

import java.util.List;

public class BankForm extends Form{
    private List<Bank> bankList;
    private Bank bank;
    private List<CreditOffer> creditOfferList;
    private List<Credit> creditList;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<Bank> getBankList() {
        return bankList;
    }

    public void setBankList(List<Bank> banksList) {
        this.bankList = banksList;
    }

    public List<CreditOffer> getCreditOfferList() {
        return creditOfferList;
    }

    public void setCreditOfferList(List<CreditOffer> creditOfferList) {
        this.creditOfferList = creditOfferList;
    }

    public List<Credit> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<Credit> creditList) {
        this.creditList = creditList;
    }
}
