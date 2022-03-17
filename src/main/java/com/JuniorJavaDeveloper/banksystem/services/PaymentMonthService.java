package com.JuniorJavaDeveloper.banksystem.services;

import com.JuniorJavaDeveloper.banksystem.entity.PaymentMonth;
import com.JuniorJavaDeveloper.banksystem.entity.PaymentSchedule;

import java.util.List;

public interface PaymentMonthService extends MainService<PaymentMonth> {
    List<PaymentMonth> findPaymentMonthsByPaymentSchedule(PaymentSchedule paymentSchedule);
}
