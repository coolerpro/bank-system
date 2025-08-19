package com.JuniorJavaDeveloper.banksystem.services.creditmanager.impl;

import com.JuniorJavaDeveloper.banksystem.entity.Credit;
import com.JuniorJavaDeveloper.banksystem.entity.PaymentMonth;
import com.JuniorJavaDeveloper.banksystem.entity.PaymentSchedule;
import com.JuniorJavaDeveloper.banksystem.services.creditmanager.PaymentMonthManager;
import com.JuniorJavaDeveloper.banksystem.services.creditmanager.PaymentScheduleManager;
import com.JuniorJavaDeveloper.banksystem.services.creditmanager.ScheduleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentScheduleManagerImpl implements PaymentScheduleManager {

    private PaymentMonthManager paymentMonthManager;
    private ScheduleManager scheduleManager;

    @Autowired
    public PaymentScheduleManagerImpl(PaymentMonthManager paymentMonthManager, ScheduleManager scheduleManager) {
        this.paymentMonthManager = paymentMonthManager;
        this.scheduleManager = scheduleManager;
    }

    public void calculatePaymentSchedule(Credit credit, LocalDate dateFirstPay, int countMonth) {

        credit.setPaymentSchedule(new PaymentSchedule());
        PaymentSchedule paymentSchedule = credit.getPaymentSchedule();

        BigDecimal sumCredit = BigDecimal.ZERO;
        BigDecimal sumPercent = BigDecimal.ZERO;
        List<BigDecimal> paysBodyMonth = new ArrayList<>();
        List<BigDecimal> paysPercentMonth = new ArrayList<>();

        sumCredit = calculateCredit(credit, countMonth, sumCredit, paysBodyMonth, paysPercentMonth);

        List<LocalDate> dateList = scheduleManager.calculateSchedule(dateFirstPay, countMonth);
        paymentSchedule.setDateFirstPayment(dateFirstPay);
        paymentSchedule.setDateEndPayment(dateList.get(dateList.size() - 1));

        for (int i = 0; i < countMonth; i++) {
            BigDecimal payMonth = paysBodyMonth.get(i).add(paysPercentMonth.get(i));
            paymentMonthManager.addPaymentMonth(credit, dateList.get(i), payMonth, paysBodyMonth.get(i), paysPercentMonth.get(i));
            sumPercent = sumPercent.add(paysPercentMonth.get(i));
        }

        credit.setSumPercent(sumPercent);
        credit.setSum(sumCredit);
    }

    private BigDecimal calculateCredit(Credit credit, int countMonth, BigDecimal sumCredit, List<BigDecimal> paysBodyMonth, List<BigDecimal> paysPercentMonth) {

        BigDecimal percentYear = credit.getCreditOffer().getInterestRate();
        BigDecimal ratioMonth = percentYear.divide(BigDecimal.valueOf(12), 6, RoundingMode.HALF_UP).divide(BigDecimal.valueOf(100), 6, RoundingMode.HALF_UP);

        BigDecimal sumBodyBalance = credit.getSumBody();

        for (int i = countMonth; i > 0; --i) {

            BigDecimal payMonthBody = sumBodyBalance.divide(BigDecimal.valueOf(i), 2, RoundingMode.HALF_UP);
            paysBodyMonth.add(payMonthBody);

            BigDecimal payMonthPercent = sumBodyBalance.multiply(ratioMonth).setScale(2, RoundingMode.HALF_UP);
            paysPercentMonth.add(payMonthPercent);

            sumCredit = sumCredit.add(payMonthPercent).add(payMonthBody);
            sumBodyBalance = sumBodyBalance.subtract(payMonthBody);

        }

        return sumCredit.setScale(2, RoundingMode.HALF_UP);
    }
}
