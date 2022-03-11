package com.JuniorJavaDeveloper.banksystem.repository;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.entity.CreditOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CreditOfferRepository  extends JpaRepository<CreditOffer, UUID> {
    @Query("SELECT cr FROM CreditOffer cr WHERE cr.bank = :bank")
    List<CreditOffer> getCreditOfferByClient(@Param("bank") Bank bank);
}
