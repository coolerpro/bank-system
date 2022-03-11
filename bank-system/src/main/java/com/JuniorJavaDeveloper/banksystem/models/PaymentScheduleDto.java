package com.JuniorJavaDeveloper.banksystem.models;

import java.util.Date;
import java.util.UUID;

public class PaymentScheduleDto {

    private UUID id;
    private Date dateFirstPayment;
    private Date dateEndPayment;

    public PaymentScheduleDto() {
    }

    public PaymentScheduleDto(UUID id, Date dateFirstPayment, Date dateEndPayment) {
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
