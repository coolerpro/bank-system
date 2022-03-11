package com.JuniorJavaDeveloper.banksystem.models.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "creditoffer")
public class CreditOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "bankid")
    private Bank bank;

    @Column(name = "creditlimit")
    private double creditLimit;

    @Column(name = "interestrate")
    private double interestRate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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
