package com.JuniorJavaDeveloper.banksystem.models;

import java.util.UUID;

public class CreditDto {

    private UUID id;
    private ClientDto client;
    private BankDto bank;
    private CreditOfferDto creditOffer;

    private PaymentScheduleDto paymentSchedule;

    private double sum;

    public CreditDto() {
    }

    public CreditDto(UUID id, ClientDto client, BankDto bank, CreditOfferDto creditOffer, PaymentScheduleDto paymentSchedule, double sum) {
        this.id = id;
        this.client = client;
        this.bank = bank;
        this.creditOffer = creditOffer;
        this.paymentSchedule = paymentSchedule;
        this.sum = sum;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public BankDto getBank() {
        return bank;
    }

    public void setBank(BankDto bank) {
        this.bank = bank;
    }

    public CreditOfferDto getCreditOffer() {
        return creditOffer;
    }

    public void setCreditOffer(CreditOfferDto creditOffer) {
        this.creditOffer = creditOffer;
    }

    public PaymentScheduleDto getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setPaymentSchedule(PaymentScheduleDto paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
