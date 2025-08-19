package com.juniorjavadeveloper.banksystem.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "paymentschedule")
public class PaymentSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "datefirstpayment")
    private LocalDate dateFirstPayment;

    @Column(name = "dateendpayment")
    private LocalDate dateEndPayment;

    @OneToMany(mappedBy = "paymentSchedule", orphanRemoval = true)
    private List<PaymentMonth> paymentMonths = new ArrayList<>();

    public void setPaymentMonths(List<PaymentMonth> paymentMonths) {
        this.paymentMonths = paymentMonths;
    }

    public List<PaymentMonth> getPaymentMonths() {
        return paymentMonths;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDateFirstPayment() {
        return dateFirstPayment;
    }

    public void setDateFirstPayment(LocalDate dateFirstPayment) {
        this.dateFirstPayment = dateFirstPayment;
    }

    public LocalDate getDateEndPayment() {
        return dateEndPayment;
    }

    public void setDateEndPayment(LocalDate dateEndPayment) {
        this.dateEndPayment = dateEndPayment;
    }
}
