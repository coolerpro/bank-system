package com.JuniorJavaDeveloper.banksystem.repository;

import com.JuniorJavaDeveloper.banksystem.entity.PaymentMonth;
import com.JuniorJavaDeveloper.banksystem.entity.PaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentMonthRepository extends JpaRepository<PaymentMonth, UUID> {
    List<PaymentMonth> findPaymentMonthsByPaymentSchedule(PaymentSchedule paymentSchedule);
}
