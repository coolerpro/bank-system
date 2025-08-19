package com.juniorjavadeveloper.banksystem.services.impl;

import com.juniorjavadeveloper.banksystem.entity.Bank;
import com.juniorjavadeveloper.banksystem.repository.BankRepository;
import com.juniorjavadeveloper.banksystem.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BankServiceImpl implements MainService<Bank> {

    private BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    @Override
    public Bank findById(UUID id) {
        return bankRepository.getById(id);
    }

    @Override
    public void save(Bank elem) {
        bankRepository.save(elem);
    }

    @Override
    public void delete(UUID id) {
        bankRepository.delete(bankRepository.getById(id));
    }
}
