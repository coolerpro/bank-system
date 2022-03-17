package com.JuniorJavaDeveloper.banksystem.services.creditbuilder;

import com.JuniorJavaDeveloper.banksystem.entity.Credit;

import java.time.LocalDate;

public interface PaymentScheduleBuilder {
    void calculatePaymentSchedule(Credit credit, LocalDate dateFirstPay, int countMonth);
}
