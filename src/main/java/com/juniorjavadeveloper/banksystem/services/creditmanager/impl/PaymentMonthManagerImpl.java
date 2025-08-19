package com.juniorjavadeveloper.banksystem.services.creditmanager.impl;

import com.juniorjavadeveloper.banksystem.entity.Credit;
import com.juniorjavadeveloper.banksystem.entity.PaymentMonth;
import com.juniorjavadeveloper.banksystem.entity.PaymentSchedule;
import com.juniorjavadeveloper.banksystem.services.creditmanager.PaymentMonthManager;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentMonthManagerImpl implements PaymentMonthManager {

    public void addPaymentMonth(Credit credit, LocalDate datePay, BigDecimal paymentSum, BigDecimal sumBody) {

        PaymentSchedule paymentSchedule = credit.getPaymentSchedule();
        List<PaymentMonth> paymentMonthList = paymentSchedule.getPaymentMonths();

        PaymentMonth paymentMonth = new PaymentMonth();

        paymentMonth.setPaymentSchedule(paymentSchedule);
        paymentMonth.setPaymentDate(datePay);

        paymentMonth.setPaymentSum(paymentSum);
        paymentMonth.setSumBody(sumBody);
        paymentMonth.setSumPercent(paymentSum.subtract(sumBody));

        paymentMonthList.add(paymentMonth);

    }
}
