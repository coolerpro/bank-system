package com.JuniorJavaDeveloper.banksystem.services.creditmanager.impl;

import com.JuniorJavaDeveloper.banksystem.entity.*;
import com.JuniorJavaDeveloper.banksystem.services.creditmanager.CreditManager;
import com.JuniorJavaDeveloper.banksystem.services.creditmanager.PaymentScheduleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreditManagerImpl implements CreditManager {

    private PaymentScheduleManager paymentScheduleManager;

    @Autowired
    public CreditManagerImpl(PaymentScheduleManager paymentScheduleManager) {
        this.paymentScheduleManager = paymentScheduleManager;
    }

    public void calculateCredit(Credit credit, LocalDate dateFirstPay, int countMonth) {
        paymentScheduleManager.calculatePaymentSchedule(credit, dateFirstPay, countMonth);
    }


}
