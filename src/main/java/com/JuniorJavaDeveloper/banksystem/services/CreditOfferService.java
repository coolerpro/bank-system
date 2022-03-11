package com.JuniorJavaDeveloper.banksystem.services;


import com.JuniorJavaDeveloper.banksystem.models.BankDto;
import com.JuniorJavaDeveloper.banksystem.models.CreditOfferDto;

import java.util.List;
import java.util.UUID;

public interface CreditOfferService {

    List<CreditOfferDto> creditOffersList();
    List<CreditOfferDto> creditOffersList(BankDto bankDto);
    CreditOfferDto getCreditOffer(UUID id);
    void save(CreditOfferDto creditOfferNew) throws Exception;
    void update(CreditOfferDto creditOfferEdit) throws Exception;
    void delete(UUID id);

}
