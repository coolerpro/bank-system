package com.example.JuniorJavaDeveloper.banksystem.services.impl;


import com.example.JuniorJavaDeveloper.banksystem.models.PaymentScheduleDto;
import com.example.JuniorJavaDeveloper.banksystem.models.entity.PaymentSchedule;
import com.example.JuniorJavaDeveloper.banksystem.repository.PaymentScheduleRepository;
import com.example.JuniorJavaDeveloper.banksystem.services.PaymentScheduleService;
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
    public PaymentScheduleDto getPaymentSchedule(UUID id) {
        return convertToDto(paymentScheduleRepository.getById(id));
    }

    @Override
    public void save(PaymentScheduleDto paymentScheduleDto) {
        paymentScheduleRepository.saveAndFlush(convertToEnt(paymentScheduleDto));
    }

    @Override
    public void update(PaymentScheduleDto paymentScheduleDto) {
        paymentScheduleRepository.saveAndFlush(convertToEnt(paymentScheduleDto));
    }

    @Override
    public void delete(UUID id) {
        paymentScheduleRepository.delete(paymentScheduleRepository.getById(id));
    }


    private PaymentScheduleDto convertToDto(PaymentSchedule paymentSchedule) {

        PaymentScheduleDto paymentScheduleDto = new PaymentScheduleDto();

        paymentScheduleDto.setId(paymentSchedule.getId());
        paymentScheduleDto.setDateFirstPayment(paymentSchedule.getDateFirstPayment());
        paymentScheduleDto.setDateEndPayment(paymentSchedule.getDateEndPayment());

        return paymentScheduleDto;
    }

    private PaymentSchedule convertToEnt(PaymentScheduleDto paymentScheduleDto) {

        PaymentSchedule paymentSchedule = new PaymentSchedule();

        paymentSchedule.setId(paymentScheduleDto.getId());
        paymentSchedule.setDateFirstPayment(paymentScheduleDto.getDateFirstPayment());
        paymentSchedule.setDateEndPayment(paymentScheduleDto.getDateEndPayment());

        return paymentSchedule;
    }


}
