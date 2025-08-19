package com.JuniorJavaDeveloper.banksystem.services.creditmanager;

import com.JuniorJavaDeveloper.banksystem.entity.Credit;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PaymentMonthManager {
    void addPaymentMonth(Credit credit, LocalDate datePay, BigDecimal paymentSum, BigDecimal sumBody, BigDecimal sumPercent);
}
