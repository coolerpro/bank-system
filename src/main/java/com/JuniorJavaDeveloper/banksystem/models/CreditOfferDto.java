package com.JuniorJavaDeveloper.banksystem.models;

import java.util.UUID;

public class CreditOfferDto {


    private UUID id;
    private double creditLimit;
    private double interestRate;
    private CreditOrganization creditOrganization;

    public CreditOfferDto() {
    }

    public CreditOfferDto(UUID id, double creditLimit, double interestRate, CreditOrganization creditOrganization) {
        this.id = id;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.creditOrganization = creditOrganization;
    }

    public CreditOrganization getCreditOrganization() {
        return creditOrganization;
    }

    public void setCreditOrganization(CreditOrganization creditOrganization) {
        this.creditOrganization = creditOrganization;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
