package com.JuniorJavaDeveloper.banksystem.models.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "paymentsbymonth")
public class PaymentByMonth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "paymentschedule_id")
    private PaymentSchedule paymentSchedule;

    @Column(name = "paymentdate")
    private Date paymentDate;

    @Column(name = "paymentsum")
    private double paymentSum;

    @Column(name = "sumbody")
    private double sumBody;

    @Column(name = "sumpercent")
    private double sumpPercent;

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
