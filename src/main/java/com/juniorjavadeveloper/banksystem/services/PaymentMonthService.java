package com.juniorjavadeveloper.banksystem.services;

import com.juniorjavadeveloper.banksystem.entity.PaymentMonth;
import com.juniorjavadeveloper.banksystem.entity.PaymentSchedule;

import java.util.List;

public interface PaymentMonthService extends MainService<PaymentMonth> {
    List<PaymentMonth> findPaymentMonthsByPaymentSchedule(PaymentSchedule paymentSchedule);
}
