package com.JuniorJavaDeveloper.banksystem.services.creditmanager;

import com.JuniorJavaDeveloper.banksystem.entity.Credit;

import java.time.LocalDate;

public interface CreditManager {
    void calculateCredit(Credit credit, LocalDate dateFirstPay, int countMonth);
}
