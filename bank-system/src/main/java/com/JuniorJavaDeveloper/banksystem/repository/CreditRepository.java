package com.JuniorJavaDeveloper.banksystem.repository;

import com.JuniorJavaDeveloper.banksystem.models.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CreditRepository  extends JpaRepository<Credit, UUID> {

    @Query("SELECT cr FROM Credit cr WHERE cr.clientId = :clientId")
    List<Credit> getCreditsByClient(@Param("clientId") UUID clientId);

    @Query("SELECT cr FROM Credit cr WHERE cr.bankId = :bankId")
    List<Credit> getCreditsByBank(@Param("bankId") UUID bankId);

    @Query("SELECT cr FROM Credit cr WHERE cr.bankId = :bankId and cr.clientId = :clientId")
    List<Credit> getCreditsByBankClient(@Param("bankId") UUID bankId, @Param("clientId") UUID clientId);


}
