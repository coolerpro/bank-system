package com.JuniorJavaDeveloper.banksystem.services.impl;

import com.JuniorJavaDeveloper.banksystem.entity.PaymentSchedule;
import com.JuniorJavaDeveloper.banksystem.repository.PaymentScheduleRepository;
import com.JuniorJavaDeveloper.banksystem.services.PaymentScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentScheduleImpl implements PaymentScheduleService {

    private PaymentScheduleRepository paymentScheduleRepository;

    @Autowired
    public PaymentScheduleImpl(PaymentScheduleRepository paymentScheduleRepository) {
        this.paymentScheduleRepository = paymentScheduleRepository;
    }

    @Override
    public PaymentSchedule getPaymentSchedule(UUID id) {
        return paymentScheduleRepository.getById(id);
    }

    @Override
    public void save(PaymentSchedule paymentSchedule) {
        paymentScheduleRepository.saveAndFlush(paymentSchedule);
    }

    @Override
    public void update(PaymentSchedule paymentSchedule) {
        paymentScheduleRepository.saveAndFlush(paymentSchedule);
    }

    @Override
    public void delete(UUID id) {
        paymentScheduleRepository.delete(paymentScheduleRepository.getById(id));
    }
}
