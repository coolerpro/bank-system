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
public interface CreditRepository  extends JpaRepository<Credit, UUID> {

    @Query("SELECT cr FROM Credit cr WHERE cr.client = :client")
    List<Credit> getCreditsByClient(@Param("client") Client client);

    @Query("SELECT cr FROM Credit cr WHERE cr.bank = :bank")
    List<Credit> getCreditsByBank(@Param("bank") Bank bank);

    @Query("SELECT cr FROM Credit cr WHERE cr.bank = :bank and cr.client = :client")
    List<Credit> getCreditsByBankClient(@Param("bank") Bank bank, @Param("client") Client client);


}
