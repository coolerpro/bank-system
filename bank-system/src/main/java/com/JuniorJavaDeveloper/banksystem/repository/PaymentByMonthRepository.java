package com.JuniorJavaDeveloper.banksystem.repository;

import com.JuniorJavaDeveloper.banksystem.models.entity.PaymentByMonth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentByMonthRepository  extends JpaRepository<PaymentByMonth, UUID> {
}
