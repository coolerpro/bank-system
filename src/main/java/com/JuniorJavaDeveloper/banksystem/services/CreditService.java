package com.JuniorJavaDeveloper.banksystem.services;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.Client;
import com.JuniorJavaDeveloper.banksystem.entity.Credit;

import java.util.List;

public interface CreditService extends MainService<Credit> {

    List<Credit> findCreditsByClient(Client client);

    List<Credit> findCreditsByBank(Bank bank);

    List<Credit> findCreditsByBankAndClient(Bank bank, Client client);

}
