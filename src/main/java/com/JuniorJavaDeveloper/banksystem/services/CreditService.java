package com.JuniorJavaDeveloper.banksystem.services;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.Client;
import com.JuniorJavaDeveloper.banksystem.entity.Credit;

import java.util.List;
import java.util.UUID;

public interface CreditService {

    List<Credit> getCredits();

    List<Credit> getCredits(Client client);

    List<Credit> getCredits(Bank bank);

    List<Credit> getCredits(Bank bank, Client client);

    Credit getCredit(UUID id);

    void save(Credit creditNew) throws Exception;

    void update(Credit creditEdit) throws Exception;

    void delete(UUID id);
}
