package com.juniorjavadeveloper.banksystem.services.creditmanager;

import com.juniorjavadeveloper.banksystem.entity.Credit;

import java.time.LocalDate;

public interface PaymentScheduleManager {
    void calculatePaymentSchedule(Credit credit, LocalDate dateFirstPay, int countMonth);
}
