package com.JuniorJavaDeveloper.banksystem.repository;

import com.JuniorJavaDeveloper.banksystem.models.entity.PaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentScheduleRepository extends JpaRepository<PaymentSchedule, UUID> {
}
