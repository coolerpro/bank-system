package com.juniorjavadeveloper.banksystem.services;

import com.juniorjavadeveloper.banksystem.entity.Bank;
import com.juniorjavadeveloper.banksystem.entity.Client;
import com.juniorjavadeveloper.banksystem.entity.Credit;

import java.util.List;

public interface CreditService extends MainService<Credit> {

    List<Credit> findCreditsByClient(Client client);

    List<Credit> findCreditsByBank(Bank bank);

    List<Credit> findCreditsByBankAndClient(Bank bank, Client client);

}
