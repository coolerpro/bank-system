package com.JuniorJavaDeveloper.banksystem.services.impl;

import com.JuniorJavaDeveloper.banksystem.models.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.models.entity.CreditOffer;
import com.JuniorJavaDeveloper.banksystem.repository.CreditOfferRepository;
import com.JuniorJavaDeveloper.banksystem.services.BankService;
import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CreditOfferServiceImpl implements CreditOfferService {

    private CreditOfferRepository creditOfferRepository;
    private BankService bankService;

    @Autowired
    public CreditOfferServiceImpl(CreditOfferRepository creditOfferRepository, BankService bankService) {
        this.creditOfferRepository = creditOfferRepository;
        this.bankService = bankService;
    }

    @Override
    public List<CreditOffer> creditOffersList() {
        return creditOfferRepository.findAll();
    }

    @Override
    public List<CreditOffer> creditOffersList(Bank bank) {
        return creditOfferRepository.getCreditOfferByClient(bank.getId());
    }

    @Override
    public CreditOffer getCreditOffer(UUID id) {
        return creditOfferRepository.getById(id);
    }

    @Override
    public void save(CreditOffer creditOfferNew) throws Exception {
        creditOfferRepository.saveAndFlush(creditOfferNew);
    }

    @Override
    public void update(CreditOffer creditOfferEdit) throws Exception {
        creditOfferRepository.saveAndFlush(creditOfferEdit);
    }

    @Override
    public void delete(UUID id) {
        creditOfferRepository.delete(creditOfferRepository.getById(id));
    }
}
