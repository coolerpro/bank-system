package com.JuniorJavaDeveloper.banksystem.services.impl;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.Client;
import com.JuniorJavaDeveloper.banksystem.entity.Credit;
import com.JuniorJavaDeveloper.banksystem.entity.CreditOffer;
import com.JuniorJavaDeveloper.banksystem.repository.CreditRepository;
import com.JuniorJavaDeveloper.banksystem.services.*;
import com.JuniorJavaDeveloper.banksystem.services.creditbuilder.CreditBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CreditServiceImpl implements CreditService {

    private CreditRepository creditRepository;
    private MainService bankService;
    private MainService clientService;
    private CreditOfferService creditOfferService;
    private MainService paymentScheduleService;
    private CreditBuilder creditBuilder;

    @Autowired
    public CreditServiceImpl(CreditRepository creditRepository, @Qualifier("bankServiceImpl") MainService bankService, @Qualifier("clientServiceImpl") MainService clientService, CreditOfferService creditOfferService, @Qualifier("paymentScheduleImpl") MainService paymentScheduleService, CreditBuilder creditBuilder) {
        this.creditRepository = creditRepository;
        this.bankService = bankService;
        this.clientService = clientService;
        this.creditOfferService = creditOfferService;
        this.paymentScheduleService = paymentScheduleService;
        this.creditBuilder = creditBuilder;
    }

    @Override
    public List<Credit> findAll() {
        return creditRepository.findAll();
    }

    @Override
    public List<Credit> findCreditsByClient(Client client) {
        return creditRepository.findCreditsByClient(client);
    }

    @Override
    public List<Credit> findCreditsByBank(Bank bank) {
        return creditRepository.findCreditsByBank(bank);
    }

    @Override
    public List<Credit> findCreditsByBankAndClient(Bank bank, Client client) {
        return creditRepository.findCreditsByBankAndClient(bank, client);
    }

    @Override
    public Credit findById(UUID id) {

        Credit credit = new Credit();

        CreditOffer creditOffer = new CreditOffer();
        creditOffer.setInterestRate(BigDecimal.valueOf(15));

        credit.setCreditOffer(creditOffer);
        credit.setSumBody(BigDecimal.valueOf(10000));

        creditBuilder.calculateCredit(credit, LocalDate.now(), 6);

        return creditRepository.getById(id);
    }

    @Override
    public void save(Credit creditNew) throws Exception {
        checkFillings(creditNew);
        creditRepository.save(creditNew);
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
