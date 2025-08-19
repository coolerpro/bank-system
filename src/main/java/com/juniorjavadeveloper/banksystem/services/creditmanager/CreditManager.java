package com.juniorjavadeveloper.banksystem.services.creditmanager;

import com.juniorjavadeveloper.banksystem.entity.Credit;

import java.time.LocalDate;

public interface CreditManager {
    void calculateCredit(Credit credit, LocalDate dateFirstPay, int countMonth);
}
