package com.JuniorJavaDeveloper.banksystem.services.creditmanager;

import com.JuniorJavaDeveloper.banksystem.entity.Credit;

import java.time.LocalDate;

public interface PaymentScheduleManager {
    void calculatePaymentSchedule(Credit credit, LocalDate dateFirstPay, int countMonth);
}
