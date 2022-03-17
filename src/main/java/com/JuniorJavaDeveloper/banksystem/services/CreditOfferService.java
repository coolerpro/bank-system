package com.JuniorJavaDeveloper.banksystem.services;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.CreditOffer;

import java.util.List;

public interface CreditOfferService extends MainService<CreditOffer> {
    List<CreditOffer> findCreditOffersByBank(Bank bank);
}
