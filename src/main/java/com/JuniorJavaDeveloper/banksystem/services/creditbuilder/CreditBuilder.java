package com.JuniorJavaDeveloper.banksystem.services.creditbuilder;

import com.JuniorJavaDeveloper.banksystem.entity.Credit;

import java.time.LocalDate;

public interface CreditBuilder {
    void calculateCredit (Credit credit, LocalDate dateFirstPay, int countMonth);
}
