package com.juniorjavadeveloper.banksystem.services.impl;

import com.juniorjavadeveloper.banksystem.entity.PaymentSchedule;
import com.juniorjavadeveloper.banksystem.repository.PaymentScheduleRepository;
import com.juniorjavadeveloper.banksystem.services.PaymentScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentScheduleImpl implements PaymentScheduleService {

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
