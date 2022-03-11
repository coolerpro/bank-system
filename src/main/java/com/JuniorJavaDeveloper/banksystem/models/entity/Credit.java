package com.JuniorJavaDeveloper.banksystem.models.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "credit")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "clientid")
    private UUID clientId;

    @Column(name = "banktid")
    private UUID bankId;

    @Column(name = "creditofferid")
    private UUID creditOfferId;

    @Column(name = "paymentscheduleid")
    private UUID paymentScheduleId;

    @Column(name = "sum")
    private double sum;

    public Credit() {
    }

    public Credit(UUID id, UUID clientId, UUID bankId, UUID creditOfferId, UUID paymentScheduleId, double sum) {
        this.id = id;
        this.clientId = clientId;
        this.bankId = bankId;
        this.creditOfferId = creditOfferId;
        this.paymentScheduleId = paymentScheduleId;
        this.sum = sum;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public UUID getBankId() {
        return bankId;
    }

    public void setBankId(UUID bankId) {
        this.bankId = bankId;
    }

    public UUID getCreditOfferId() {
        return creditOfferId;
    }

    public void setCreditOfferId(UUID creditOfferId) {
        this.creditOfferId = creditOfferId;
    }

    public UUID getPaymentScheduleId() {
        return paymentScheduleId;
    }

    public void setPaymentScheduleId(UUID paymentScheduleId) {
        this.paymentScheduleId = paymentScheduleId;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
