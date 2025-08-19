package com.JuniorJavaDeveloper.banksystem.services.creditmanager.impl;

import com.JuniorJavaDeveloper.banksystem.entity.Credit;
import com.JuniorJavaDeveloper.banksystem.entity.PaymentMonth;
import com.JuniorJavaDeveloper.banksystem.entity.PaymentSchedule;
import com.JuniorJavaDeveloper.banksystem.services.creditmanager.PaymentMonthManager;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentMonthManagerImpl implements PaymentMonthManager {

    public void addPaymentMonth(Credit credit, LocalDate datePay, BigDecimal paymentSum, BigDecimal sumBody, BigDecimal sumPercent) {

        PaymentSchedule paymentSchedule = credit.getPaymentSchedule();
        List<PaymentMonth> paymentMonthList = paymentSchedule.getPaymentMonths();

        PaymentMonth paymentMonth = new PaymentMonth();

        paymentMonth.setPaymentSchedule(paymentSchedule);
        paymentMonth.setPaymentDate(datePay);

        paymentMonth.setPaymentSum(paymentSum);
        paymentMonth.setSumBody(sumBody);
        paymentMonth.setSumPercent(sumPercent);

        paymentMonthList.add(paymentMonth);

    }
}
