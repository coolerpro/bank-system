package com.JuniorJavaDeveloper.banksystem.services.impl;

import com.JuniorJavaDeveloper.banksystem.models.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.repository.BankRepository;
import com.JuniorJavaDeveloper.banksystem.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BankServiceImpl implements BankService {

    private BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public List<Bank> banksList() {
        return bankRepository.findAll();
    }

    @Override
    public Bank getBank(UUID id) {
        return bankRepository.getById(id);
    }

    @Override
    public void save(Bank bankNew) {
        bankRepository.saveAndFlush(bankNew);
    }

    @Override
    public void update(Bank bankEdit) {
        bankRepository.saveAndFlush(bankEdit);
    }

    @Override
    public void delete(UUID id) {
        bankRepository.delete(bankRepository.getById(id));
    }
}
