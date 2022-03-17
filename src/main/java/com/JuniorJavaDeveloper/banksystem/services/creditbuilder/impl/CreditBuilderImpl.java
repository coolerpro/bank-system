package com.JuniorJavaDeveloper.banksystem.services.creditbuilder.impl;

import com.JuniorJavaDeveloper.banksystem.entity.*;
import com.JuniorJavaDeveloper.banksystem.services.creditbuilder.CreditBuilder;
import com.JuniorJavaDeveloper.banksystem.services.creditbuilder.PaymentScheduleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreditBuilderImpl implements CreditBuilder {

    private PaymentScheduleBuilder paymentScheduleBuilder;

    @Autowired
    public CreditBuilderImpl(PaymentScheduleBuilder paymentScheduleBuilder) {
        this.paymentScheduleBuilder = paymentScheduleBuilder;
    }

    public void calculateCredit(Credit credit, LocalDate dateFirstPay, int countMonth) {
        paymentScheduleBuilder.calculatePaymentSchedule(credit, dateFirstPay, countMonth);
    }


}
