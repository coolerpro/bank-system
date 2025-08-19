package com.juniorjavadeveloper.banksystem.repository;

import com.juniorjavadeveloper.banksystem.entity.Bank;
import com.juniorjavadeveloper.banksystem.entity.Client;
import com.juniorjavadeveloper.banksystem.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CreditRepository extends JpaRepository<Credit, UUID> {

    List<Credit> findCreditsByClient(Client client);

    List<Credit> findCreditsByBank(Bank bank);

    List<Credit> findCreditsByBankAndClient(Bank bank, Client client);

}
