package com.juniorjavadeveloper.banksystem.repository;

import com.juniorjavadeveloper.banksystem.entity.Bank;
import com.juniorjavadeveloper.banksystem.entity.CreditOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CreditOfferRepository extends JpaRepository<CreditOffer, UUID> {
    List<CreditOffer> findCreditOffersByBank(Bank bank);
}
