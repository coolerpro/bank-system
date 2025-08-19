package com.juniorjavadeveloper.banksystem.services;

import com.juniorjavadeveloper.banksystem.entity.Bank;
import com.juniorjavadeveloper.banksystem.entity.CreditOffer;

import java.util.List;

public interface CreditOfferService extends MainService<CreditOffer> {
    List<CreditOffer> findCreditOffersByBank(Bank bank);
}
