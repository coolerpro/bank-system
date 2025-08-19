package com.juniorjavadeveloper.banksystem.repository;

import com.juniorjavadeveloper.banksystem.entity.PaymentMonth;
import com.juniorjavadeveloper.banksystem.entity.PaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentMonthRepository extends JpaRepository<PaymentMonth, UUID> {
    List<PaymentMonth> findPaymentMonthsByPaymentSchedule(PaymentSchedule paymentSchedule);
    void deleteByPaymentSchedule(PaymentSchedule paymentSchedule);
}
