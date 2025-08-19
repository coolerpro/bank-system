package com.JuniorJavaDeveloper.banksystem.services.creditmanager.impl;

import com.JuniorJavaDeveloper.banksystem.entity.Credit;
import com.JuniorJavaDeveloper.banksystem.entity.CreditOffer;
import com.JuniorJavaDeveloper.banksystem.entity.PaymentMonth;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PaymentScheduleManagerImplTest {

    @Test
    void interestDecreasesEachMonth() {
        Credit credit = new Credit();
        CreditOffer offer = new CreditOffer();
        offer.setInterestRate(BigDecimal.valueOf(12)); // 12% yearly
        credit.setCreditOffer(offer);
        credit.setSumBody(BigDecimal.valueOf(1200));

        PaymentMonthManagerImpl paymentMonthManager = new PaymentMonthManagerImpl();
        ScheduleManagerImpl scheduleManager = new ScheduleManagerImpl();
        PaymentScheduleManagerImpl manager = new PaymentScheduleManagerImpl(paymentMonthManager, scheduleManager);

        manager.calculatePaymentSchedule(credit, LocalDate.of(2023, 1, 1), 12);

        List<PaymentMonth> months = credit.getPaymentSchedule().getPaymentMonths();
        assertTrue(months.get(0).getSumPercent().compareTo(months.get(1).getSumPercent()) > 0,
                "Interest should decrease each month");
    }
}
