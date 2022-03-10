package com.example.JuniorJavaDeveloper.banksystem.repository;

import com.example.JuniorJavaDeveloper.banksystem.models.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankRepository  extends JpaRepository<Bank, UUID> {
}
