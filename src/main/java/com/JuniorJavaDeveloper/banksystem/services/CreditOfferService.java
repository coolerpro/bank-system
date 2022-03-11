package com.JuniorJavaDeveloper.banksystem.services;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.CreditOffer;

import java.util.List;
import java.util.UUID;

public interface CreditOfferService {

    List<CreditOffer> creditOffersList();

    List<CreditOffer> creditOffersList(Bank bank);

    CreditOffer getCreditOffer(UUID id);

    void save(CreditOffer creditOfferNew) throws Exception;

    void update(CreditOffer creditOfferEdit) throws Exception;

    void delete(UUID id);

}
