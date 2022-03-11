package com.JuniorJavaDeveloper.banksystem.models.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "creditoffer")
public class CreditOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "bankid")
    private UUID bankId;

    @Column(name = "creditlimit")
    private double creditLimit;

    @Column(name = "interestrate")
    private double interestRate;

    public CreditOffer() {
    }

    public CreditOffer(UUID id, UUID bankId, double creditLimit, double interestRate) {
        this.id = id;
        this.bankId = bankId;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getBankId() {
        return bankId;
    }

    public void setBankId(UUID bankId) {
        this.bankId = bankId;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
