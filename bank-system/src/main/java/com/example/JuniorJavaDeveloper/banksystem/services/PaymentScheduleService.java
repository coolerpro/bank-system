package com.example.JuniorJavaDeveloper.banksystem.services;



import com.example.JuniorJavaDeveloper.banksystem.models.PaymentScheduleDto;

import java.util.UUID;

public interface PaymentScheduleService {

    PaymentScheduleDto getPaymentSchedule(UUID id);
    void save(PaymentScheduleDto paymentScheduleDto);
    void update(PaymentScheduleDto paymentScheduleDto);
    void delete(UUID id);
}
