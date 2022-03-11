package com.JuniorJavaDeveloper.banksystem.services.impl;

import com.JuniorJavaDeveloper.banksystem.models.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.models.entity.Client;
import com.JuniorJavaDeveloper.banksystem.models.entity.Credit;
import com.JuniorJavaDeveloper.banksystem.repository.CreditRepository;
import com.JuniorJavaDeveloper.banksystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CreditServiceImpl implements CreditService {

    private CreditRepository creditRepository;
    private BankService bankService;
    private ClientService clientService;
    private CreditOfferService creditOfferService;
    private PaymentScheduleService paymentScheduleService;

    @Autowired
    public CreditServiceImpl(CreditRepository creditRepository, BankService bankService, ClientService clientService, CreditOfferService creditOfferService, PaymentScheduleService paymentScheduleService) {
        this.creditRepository = creditRepository;
        this.bankService = bankService;
        this.clientService = clientService;
        this.creditOfferService = creditOfferService;
        this.paymentScheduleService = paymentScheduleService;
    }

    @Override
    public List<Credit> getCredits() {
        return creditRepository.findAll();
    }

    @Override
    public List<Credit> getCredits(Client client) {
        return creditRepository.getCreditsByClient(client.getId());
    }

    @Override
    public List<Credit> getCredits(Bank bank) {
        return creditRepository.getCreditsByBank(bank.getId());
    }

    @Override
    public List<Credit> getCredits(Bank bank, Client client) {
        return creditRepository.getCreditsByBankClient(bank.getId(), client.getId());
    }


    @Override
    public Credit getCredit(UUID id) {
        return creditRepository.getById(id);
    }

    @Override
    public void save(Credit creditNew) throws Exception {
        checkFillings(creditNew);
        creditRepository.saveAndFlush(creditNew);
    }

    @Override
    public void update(Credit creditEdit) throws Exception {
        checkFillings(creditEdit);
        creditRepository.saveAndFlush(creditEdit);
    }

    @Override
    public void delete(UUID id) {
        creditRepository.delete(creditRepository.getById(id));
    }

    private void checkFillings(Credit credit) throws Exception {
        if (credit.getClient() == null) {
            throw new Exception("Null in the required field clientId");
        }
        if (credit.getBank() == null) {
            throw new Exception("Null in the required field banktId");
        }
        if (credit.getCreditOffer() == null) {
            throw new Exception("Null in the required field creditOfferId");
        }
        if (credit.getPaymentSchedule() == null) {
            throw new Exception("Null in the required field paymentScheduleId");
        }
    }
}
