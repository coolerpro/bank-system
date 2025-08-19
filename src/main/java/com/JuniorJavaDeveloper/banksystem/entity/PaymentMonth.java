package com.JuniorJavaDeveloper.banksystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "paymentmonth")
public class PaymentMonth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "paymentscheduleid")
    private PaymentSchedule paymentSchedule;

    @NotNull
    @Column(name = "paymentdate")
    private LocalDate paymentDate;

    @NotNull
    @Column(name = "paymentsum")
    private BigDecimal paymentSum;

    @NotNull
    @Column(name = "sumbody")
    private BigDecimal sumBody;

    @NotNull
    @Column(name = "sumpercent")
    private BigDecimal sumPercent;

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

    public BigDecimal getSumPercent() {
        return sumPercent;
    }

    public void setSumPercent(BigDecimal sumPercent) {
        this.sumPercent = sumPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMonth that = (PaymentMonth) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
