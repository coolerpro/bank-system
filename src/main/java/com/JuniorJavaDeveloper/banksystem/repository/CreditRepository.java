package com.JuniorJavaDeveloper.banksystem.repository;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.Client;
import com.JuniorJavaDeveloper.banksystem.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CreditRepository extends JpaRepository<Credit, UUID> {

    List<Credit> findCreditsByClient(Client client);

    List<Credit> findCreditsByBank(Bank bank);

    List<Credit> findCreditsByBankAndClient(Bank bank, Client client);

}
