package com.juniorjavadeveloper.banksystem.services.impl;

import com.juniorjavadeveloper.banksystem.entity.PaymentMonth;
import com.juniorjavadeveloper.banksystem.entity.PaymentSchedule;
import com.juniorjavadeveloper.banksystem.repository.PaymentMonthRepository;
import com.juniorjavadeveloper.banksystem.services.PaymentMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentMonthImpl implements PaymentMonthService {

    private PaymentMonthRepository paymentMonthRepository;

    @Autowired
    public PaymentMonthImpl(PaymentMonthRepository paymentMonthRepository) {
        this.paymentMonthRepository = paymentMonthRepository;
    }

    @Override
    public List<PaymentMonth> findAll() {
        return paymentMonthRepository.findAll();
    }

    @Override
    public List<PaymentMonth> findPaymentMonthsByPaymentSchedule(PaymentSchedule paymentSchedule) {
        return paymentMonthRepository.findPaymentMonthsByPaymentSchedule(paymentSchedule);
    }

    @Override
    public PaymentMonth findById(UUID id) {
        return paymentMonthRepository.getById(id);
    }

    @Override
    public void save(PaymentMonth elem) throws Exception {
        paymentMonthRepository.save(elem);
    }

    @Override
    public void delete(UUID id) {
        PaymentMonth paymentMonth = paymentMonthRepository.getById(id);
        paymentMonthRepository.delete(paymentMonth);
    }
}
