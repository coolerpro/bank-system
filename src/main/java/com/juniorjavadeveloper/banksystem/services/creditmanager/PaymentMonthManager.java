package com.juniorjavadeveloper.banksystem.services.creditmanager;

import com.juniorjavadeveloper.banksystem.entity.Credit;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PaymentMonthManager {
    void addPaymentMonth(Credit credit, LocalDate datePay, BigDecimal paymentSum, BigDecimal sumBody);
}
