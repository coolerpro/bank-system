package com.JuniorJavaDeveloper.banksystem.forms;

import com.JuniorJavaDeveloper.banksystem.entity.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class CreditForm extends Form{

    private Credit credit;
    private List<Credit> creditList;
    private List<Bank> bankList;
    private List<Client> clientList;
    private List<CreditOffer> creditOfferList;
    private List<PaymentMonth> paymentMonths;

    private UUID bankId;
    private UUID clientId;
    private UUID creditOfferId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateFirstPayment;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateEndPayment;
    private int countMonth;

    private BigDecimal sum;
    private BigDecimal sumBody;
    private BigDecimal sumPercent;

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public List<Credit> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<Credit> creditList) {
        this.creditList = creditList;
    }

    public List<Bank> getBankList() {
        return bankList;
    }

    public void setBankList(List<Bank> bankList) {
        this.bankList = bankList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<CreditOffer> getCreditOfferList() {
        return creditOfferList;
    }

    public void setCreditOfferList(List<CreditOffer> creditOfferList) {
        this.creditOfferList = creditOfferList;
    }

    public UUID getBankId() {
        return bankId;
    }

    public void setBankId(UUID bankId) {
        this.bankId = bankId;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public UUID getCreditOfferId() {
        return creditOfferId;
    }

    public void setCreditOfferId(UUID creditOfferId) {
        this.creditOfferId = creditOfferId;
    }

    public int getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(int countMonth) {
        this.countMonth = countMonth;
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

    public List<PaymentMonth> getPaymentMonths() {
        return paymentMonths;
    }

    public void setPaymentMonths(List<PaymentMonth> paymentMonths) {
        this.paymentMonths = paymentMonths;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
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
}
