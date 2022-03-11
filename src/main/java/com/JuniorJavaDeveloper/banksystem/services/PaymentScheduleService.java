package com.JuniorJavaDeveloper.banksystem.services;

import com.JuniorJavaDeveloper.banksystem.entity.PaymentSchedule;

import java.util.UUID;

public interface PaymentScheduleService {

    PaymentSchedule getPaymentSchedule(UUID id);

    void save(PaymentSchedule paymentSchedule);

    void update(PaymentSchedule paymentSchedule);

    void delete(UUID id);
}
