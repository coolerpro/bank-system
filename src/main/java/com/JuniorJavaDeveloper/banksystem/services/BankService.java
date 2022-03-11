package com.JuniorJavaDeveloper.banksystem.services;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;

import java.util.List;
import java.util.UUID;

public interface BankService {

    List<Bank> banksList();

    Bank getBank(UUID id);

    void save(Bank bankNew);

    void update(Bank bankEdit);

    void delete(UUID id);
}
