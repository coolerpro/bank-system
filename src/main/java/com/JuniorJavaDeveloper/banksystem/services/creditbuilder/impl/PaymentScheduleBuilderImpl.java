package com.JuniorJavaDeveloper.banksystem.services.creditbuilder.impl;

import com.JuniorJavaDeveloper.banksystem.entity.Credit;
import com.JuniorJavaDeveloper.banksystem.entity.PaymentMonth;
import com.JuniorJavaDeveloper.banksystem.entity.PaymentSchedule;
import com.JuniorJavaDeveloper.banksystem.services.creditbuilder.PaymentMonthBuilder;
import com.JuniorJavaDeveloper.banksystem.services.creditbuilder.PaymentScheduleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        PaymentSchedule paymentSchedule = credit.getPaymentSchedule();

        BigDecimal sumCredit = BigDecimal.ZERO;
        BigDecimal sumPercent = BigDecimal.ZERO;
        List<BigDecimal> paysBodyMonth = new ArrayList<>();

        sumCredit = calculateCredit(credit, countMonth, sumCredit, paysBodyMonth);
        BigDecimal payMonth = sumCredit.divide(BigDecimal.valueOf(countMonth), 2, RoundingMode.HALF_UP);

        dateList = scheduleBuilder.calculateSchedule(dateFirstPay, countMonth);
        paymentSchedule.setDateFirstPayment(dateFirstPay);
        paymentSchedule.setDateEndPayment(dateList.get(dateList.size() - 1));

        for (int i = 0; i < countMonth; i++) {
            paymentMonthBuilder.addPaymentMonth(credit, dateList.get(i), payMonth, paysBodyMonth.get(i));
        }

        for (PaymentMonth payment : credit.getPaymentSchedule().getPaymentMonths()) {
            sumPercent = sumPercent.add(payment.getSumpPercent());
        }

        credit.setSumPercent(sumPercent);
        credit.setSum(payMonth.multiply(BigDecimal.valueOf(countMonth)));
    }

    private BigDecimal calculateCredit(Credit credit, int countMonth, BigDecimal sumCredit, List<BigDecimal> paysBodyMonth) {

        BigDecimal percentYear = credit.getCreditOffer().getInterestRate();
        BigDecimal ratioMonth = percentYear.divide(BigDecimal.valueOf(12), 6, RoundingMode.HALF_UP).divide(BigDecimal.valueOf(100), 6, RoundingMode.HALF_UP);

        BigDecimal sumBodyBalance = credit.getSumBody();

        for (int i = countMonth; i > 0; --i) {

            BigDecimal payMonthBody = sumBodyBalance.divide(BigDecimal.valueOf(i), 2, RoundingMode.HALF_UP);
            paysBodyMonth.add(payMonthBody);

            BigDecimal payMonthPercent = sumBodyBalance.multiply(ratioMonth);

            sumCredit = sumCredit.add(payMonthPercent).add(payMonthBody);
            sumBodyBalance = sumBodyBalance.subtract(payMonthBody);

        }

        return sumCredit;
    }
}
