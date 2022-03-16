package com.JuniorJavaDeveloper.banksystem.services.creditbuilder.impl;

import com.JuniorJavaDeveloper.banksystem.entity.Credit;
import com.JuniorJavaDeveloper.banksystem.entity.PaymentMonth;
import com.JuniorJavaDeveloper.banksystem.entity.PaymentSchedule;
import com.JuniorJavaDeveloper.banksystem.services.creditbuilder.PaymentMonthBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentMonthBuilderImpl implements PaymentMonthBuilder {

    public void addPaymentMonth(Credit credit, LocalDate datePay, BigDecimal paymentSum, BigDecimal sumBody) {

        PaymentSchedule paymentSchedule = credit.getPaymentSchedule();
        List<PaymentMonth> paymentMonthList = paymentSchedule.getPaymentMonths();

        PaymentMonth paymentMonth = new PaymentMonth();

        paymentMonth.setPaymentSchedule(paymentSchedule);
        paymentMonth.setPaymentDate(datePay);

        paymentMonth.setPaymentSum(paymentSum);
        paymentMonth.setSumBody(sumBody);
        paymentMonth.setSumpPercent(paymentSum.subtract(sumBody));

        paymentMonthList.add(paymentMonth);

    }
}
