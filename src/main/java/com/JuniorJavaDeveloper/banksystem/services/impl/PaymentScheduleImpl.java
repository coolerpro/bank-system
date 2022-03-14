package com.JuniorJavaDeveloper.banksystem.services.impl;

import com.JuniorJavaDeveloper.banksystem.entity.PaymentSchedule;
import com.JuniorJavaDeveloper.banksystem.repository.PaymentScheduleRepository;
import com.JuniorJavaDeveloper.banksystem.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentScheduleImpl implements MainService<PaymentSchedule> {

    private PaymentScheduleRepository paymentScheduleRepository;

    @Autowired
    public PaymentScheduleImpl(PaymentScheduleRepository paymentScheduleRepository) {
        this.paymentScheduleRepository = paymentScheduleRepository;
    }

    @Override
    public List<PaymentSchedule> findAll() {
        return paymentScheduleRepository.findAll();
    }

    @Override
    public PaymentSchedule findById(UUID id) {
        return paymentScheduleRepository.getById(id);
    }

    @Override
    public void save(PaymentSchedule paymentSchedule) {
        paymentScheduleRepository.save(paymentSchedule);
    }

    @Override
    public void delete(UUID id) {
        paymentScheduleRepository.delete(paymentScheduleRepository.getById(id));
    }
}
