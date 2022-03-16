package com.JuniorJavaDeveloper.banksystem.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "paymentmonth")
public class PaymentMonth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "paymentscheduleid")
    private PaymentSchedule paymentSchedule;

    @Column(name = "paymentdate")
    private LocalDate paymentDate;

    @Column(name = "paymentsum")
    private BigDecimal paymentSum;

    @Column(name = "sumbody")
    private BigDecimal sumBody;

    @Column(name = "sumpercent")
    private BigDecimal sumpPercent;

    @Column(name = "paid")
    private boolean paid;

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PaymentSchedule getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(BigDecimal paymentSum) {
        this.paymentSum = paymentSum;
    }

    public BigDecimal getSumBody() {
        return sumBody;
    }

    public void setSumBody(BigDecimal sumBody) {
        this.sumBody = sumBody;
    }

    public BigDecimal getSumpPercent() {
        return sumpPercent;
    }

    public void setSumpPercent(BigDecimal sumpPercent) {
        this.sumpPercent = sumpPercent;
    }
}
