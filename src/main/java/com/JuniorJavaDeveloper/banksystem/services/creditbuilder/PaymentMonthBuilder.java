package com.JuniorJavaDeveloper.banksystem.services.creditbuilder;

import com.JuniorJavaDeveloper.banksystem.entity.Credit;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PaymentMonthBuilder {
    void addPaymentMonth(Credit credit, LocalDate datePay, BigDecimal paymentSum, BigDecimal sumBody);
}
