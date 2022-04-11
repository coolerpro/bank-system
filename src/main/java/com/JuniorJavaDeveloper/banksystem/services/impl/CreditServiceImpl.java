package com.JuniorJavaDeveloper.banksystem.services.impl;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.Client;
import com.JuniorJavaDeveloper.banksystem.entity.Credit;
import com.JuniorJavaDeveloper.banksystem.entity.PaymentMonth;
import com.JuniorJavaDeveloper.banksystem.repository.CreditRepository;
import com.JuniorJavaDeveloper.banksystem.repository.PaymentMonthRepository;
import com.JuniorJavaDeveloper.banksystem.repository.PaymentScheduleRepository;
import com.JuniorJavaDeveloper.banksystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CreditServiceImpl implements CreditService {

    private CreditRepository creditRepository;
    private PaymentScheduleRepository paymentScheduleRepository;
    private PaymentMonthRepository paymentMonthRepository;

    @Autowired
    public CreditServiceImpl(CreditRepository creditRepository, PaymentScheduleRepository paymentScheduleRepository, PaymentMonthRepository paymentMonthRepository) {
        this.creditRepository = creditRepository;
        this.paymentScheduleRepository = paymentScheduleRepository;
        this.paymentMonthRepository = paymentMonthRepository;
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
        return creditRepository.getById(id);
    }

    @Override
    public void save(Credit creditNew) throws Exception {
        checkFillings(creditNew);
        paymentScheduleRepository.save(creditNew.getPaymentSchedule());
        for (PaymentMonth paymentMonth:
             creditNew.getPaymentSchedule().getPaymentMonths()) {
            paymentMonthRepository.save(paymentMonth);
        }
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
