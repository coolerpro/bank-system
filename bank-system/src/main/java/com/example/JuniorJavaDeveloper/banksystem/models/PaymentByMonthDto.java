package com.example.JuniorJavaDeveloper.banksystem.models;

import java.util.Date;
import java.util.UUID;

public class PaymentByMonthDto {
    private UUID id;
    private PaymentScheduleDto paymentSchedule;
    private Date paymentDate;
    private double paymentSum;
    private double sumBody;
    private double sumpPercent;

    public PaymentByMonthDto() {
    }

    public PaymentByMonthDto(UUID id, PaymentScheduleDto paymentSchedule, Date paymentDate, double paymentSum, double sumBody, double sumpPercent) {
        this.id = id;
        this.paymentSchedule = paymentSchedule;
        this.paymentDate = paymentDate;
        this.paymentSum = paymentSum;
        this.sumBody = sumBody;
        this.sumpPercent = sumpPercent;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PaymentScheduleDto getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setPaymentSchedule(PaymentScheduleDto paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(double paymentSum) {
        this.paymentSum = paymentSum;
    }

    public double getSumBody() {
        return sumBody;
    }

    public void setSumBody(double sumBody) {
        this.sumBody = sumBody;
    }

    public double getSumpPercent() {
        return sumpPercent;
    }

    public void setSumpPercent(double sumpPercent) {
        this.sumpPercent = sumpPercent;
    }
}
