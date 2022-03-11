package com.JuniorJavaDeveloper.banksystem.models.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "paymentschedule")
public class PaymentSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "datefirstpayment")
    private Date dateFirstPayment;

    @Column(name = "dateendpayment")
    private Date dateEndPayment;

    public PaymentSchedule() {
    }

    public PaymentSchedule(UUID id, Date dateFirstPayment, Date dateEndPayment) {
        this.id = id;
        this.dateFirstPayment = dateFirstPayment;
        this.dateEndPayment = dateEndPayment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDateFirstPayment() {
        return dateFirstPayment;
    }

    public void setDateFirstPayment(Date dateFirstPayment) {
        this.dateFirstPayment = dateFirstPayment;
    }

    public Date getDateEndPayment() {
        return dateEndPayment;
    }

    public void setDateEndPayment(Date dateEndPayment) {
        this.dateEndPayment = dateEndPayment;
    }
}
