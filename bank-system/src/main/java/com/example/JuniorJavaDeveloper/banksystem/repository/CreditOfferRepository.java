package com.example.JuniorJavaDeveloper.banksystem.repository;

import com.example.JuniorJavaDeveloper.banksystem.models.entity.CreditOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CreditOfferRepository  extends JpaRepository<CreditOffer, UUID> {
    @Query("SELECT cr FROM CreditOffer cr WHERE cr.bankId = :bankId")
    List<CreditOffer> getCreditOfferByClient(@Param("bankId") UUID bankId);
}
