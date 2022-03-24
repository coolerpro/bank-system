package com.JuniorJavaDeveloper.banksystem.forms;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.CreditOffer;

import java.util.List;
import java.util.UUID;

public class CreditOfferForm extends Form{

    private List<CreditOffer> creditOffersList;
    private CreditOffer creditOffer;
    private List<Bank>bankList;
    private UUID bankId;

    public UUID getBankId() {
        return bankId;
    }

    public void setBankId(UUID bankId) {
        this.bankId = bankId;
    }

    public CreditOffer getCreditOffer() {
        return creditOffer;
    }

    public void setCreditOffer(CreditOffer creditOffer) {
        this.creditOffer = creditOffer;
    }

    public List<Bank> getBankList() {
        return bankList;
    }

    public void setBankList(List<Bank> bankList) {
        this.bankList = bankList;
    }

    public List<CreditOffer> getCreditOffersList() {
        return creditOffersList;
    }

    public void setCreditOffersList(List<CreditOffer> creditOffersList) {
        this.creditOffersList = creditOffersList;
    }
}
