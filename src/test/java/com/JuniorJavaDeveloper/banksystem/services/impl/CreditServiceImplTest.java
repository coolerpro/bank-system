package com.JuniorJavaDeveloper.banksystem.services.impl;

import com.JuniorJavaDeveloper.banksystem.entity.*;
import com.JuniorJavaDeveloper.banksystem.repository.CreditRepository;
import com.JuniorJavaDeveloper.banksystem.repository.PaymentMonthRepository;
import com.JuniorJavaDeveloper.banksystem.repository.PaymentScheduleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreditServiceImplTest {

    @Mock
    private CreditRepository creditRepository;
    @Mock
    private PaymentScheduleRepository paymentScheduleRepository;
    @Mock
    private PaymentMonthRepository paymentMonthRepository;

    private CreditServiceImpl creditService;

    @BeforeEach
    void setUp() {
        creditService = new CreditServiceImpl(creditRepository, paymentScheduleRepository, paymentMonthRepository);
    }

    @Test
    void saveStoresCreditWithScheduleAndMonths() throws Exception {
        Credit credit = buildValidCredit();

        creditService.save(credit);

        verify(paymentScheduleRepository).save(credit.getPaymentSchedule());
        verify(paymentMonthRepository, times(credit.getPaymentSchedule().getPaymentMonths().size())).save(any(PaymentMonth.class));
        verify(creditRepository).save(credit);
    }

    @Test
    void saveThrowsExceptionWhenClientMissing() {
        Credit credit = new Credit();
        credit.setBank(new Bank());
        credit.setCreditOffer(new CreditOffer());
        credit.setPaymentSchedule(new PaymentSchedule());

        Exception ex = assertThrows(Exception.class, () -> creditService.save(credit));
        assertTrue(ex.getMessage().toLowerCase().contains("client"));
    }

    private Credit buildValidCredit() {
        Credit credit = new Credit();
        credit.setClient(new Client());
        credit.setBank(new Bank());
        credit.setCreditOffer(new CreditOffer());

        PaymentSchedule schedule = new PaymentSchedule();
        List<PaymentMonth> months = Arrays.asList(new PaymentMonth(), new PaymentMonth());
        schedule.setPaymentMonths(months);
        credit.setPaymentSchedule(schedule);

        return credit;
    }
}

