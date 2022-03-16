package com.JuniorJavaDeveloper.banksystem.services.creditbuilder.impl;

import com.JuniorJavaDeveloper.banksystem.entity.Credit;
import com.JuniorJavaDeveloper.banksystem.entity.PaymentSchedule;
import com.JuniorJavaDeveloper.banksystem.services.creditbuilder.PaymentMonthBuilder;
import com.JuniorJavaDeveloper.banksystem.services.creditbuilder.PaymentScheduleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentScheduleBuilderImpl implements PaymentScheduleBuilder {

    private PaymentMonthBuilder paymentMonthBuilder;
    private ScheduleBuilderImpl scheduleBuilder;

    private List<LocalDate> dateList;

    @Autowired
    public PaymentScheduleBuilderImpl(PaymentMonthBuilder paymentMonthBuilder, ScheduleBuilderImpl scheduleBuilder) {
        this.paymentMonthBuilder = paymentMonthBuilder;
        this.scheduleBuilder = scheduleBuilder;
    }

    public void calculatePaymentSchedule(Credit credit, LocalDate dateFirstPay, int countMonth) {

        credit.setPaymentSchedule(new PaymentSchedule());

        BigDecimal sumCredit = BigDecimal.ZERO;
        List<BigDecimal> paysBodyMonth = new ArrayList<>();

        calculateCredit(credit, countMonth, sumCredit, paysBodyMonth);

        dateList = scheduleBuilder.calculateSchedule(dateFirstPay, countMonth);
        BigDecimal payMonth = sumCredit.divide(BigDecimal.valueOf(countMonth));

        for (int i = 0; i < countMonth; i++) {
            paymentMonthBuilder.addPaymentMonth(credit, dateList.get(i), payMonth, paysBodyMonth.get(i));
        }
    }

    private void calculateCredit(Credit credit, int countMonth, BigDecimal sumCredit, List<BigDecimal> paysBodyMonth) {

        BigDecimal percentYear = credit.getCreditOffer().getInterestRate();
        BigDecimal ratioMonth = percentYear.divide(BigDecimal.valueOf(12)).divide(BigDecimal.valueOf(100));

        BigDecimal sumBodyBalance = credit.getSum();

        for (int i = countMonth; i > 0; --i) {

            BigDecimal payMonthBody = sumBodyBalance.divide(BigDecimal.valueOf(i));
            paysBodyMonth.add(payMonthBody);

            BigDecimal payMonthPercent = sumBodyBalance.multiply(ratioMonth);

            sumCredit = sumCredit.add(payMonthPercent).add(payMonthBody);
            sumBodyBalance = sumBodyBalance.subtract(payMonthBody);

        }
    }
}
