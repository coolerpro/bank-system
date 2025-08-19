package com.juniorjavadeveloper.banksystem.repository;

import com.juniorjavadeveloper.banksystem.entity.PaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentScheduleRepository extends JpaRepository<PaymentSchedule, UUID> {
}
