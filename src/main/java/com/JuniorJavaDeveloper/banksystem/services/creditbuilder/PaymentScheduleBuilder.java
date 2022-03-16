package com.JuniorJavaDeveloper.banksystem.services.creditbuilder;

import com.JuniorJavaDeveloper.banksystem.entity.Credit;

import java.time.LocalDate;
import java.util.Date;

public interface PaymentScheduleBuilder {
    void calculatePaymentSchedule(Credit credit, LocalDate dateFirstPay, int countMonth);
}
