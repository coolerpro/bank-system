package com.JuniorJavaDeveloper.banksystem.services.impl;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.CreditOffer;
import com.JuniorJavaDeveloper.banksystem.repository.CreditOfferRepository;
import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CreditOfferServiceImpl implements CreditOfferService {

    private CreditOfferRepository creditOfferRepository;

    @Autowired
    public CreditOfferServiceImpl(CreditOfferRepository creditOfferRepository) {
        this.creditOfferRepository = creditOfferRepository;
    }

    @Override
    public List<CreditOffer> findAll() {
        return creditOfferRepository.findAll();
    }

    @Override
    public List<CreditOffer> findCreditOffersByBank(Bank bank) {
        return creditOfferRepository.findCreditOffersByBank(bank);
    }

    @Override
    public CreditOffer findById(UUID id) {
        return creditOfferRepository.getById(id);
    }

    @Override
    public void save(CreditOffer creditOfferNew) {
        creditOfferRepository.save(creditOfferNew);
    }

    @Override
    public void delete(UUID id) {
        creditOfferRepository.delete(creditOfferRepository.getById(id));
    }
}
