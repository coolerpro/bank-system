package com.JuniorJavaDeveloper.banksystem.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "credit")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "clientid")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "banktid")
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "creditofferid")
    private CreditOffer creditOffer;

    @ManyToOne
    @JoinColumn(name = "paymentscheduleid")
    private PaymentSchedule paymentSchedule;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "sumbody")
    private BigDecimal sumBody;

    @Column(name = "sumpercent")
    private BigDecimal sumPercent;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CreditOffer getCreditOffer() {
        return creditOffer;
    }

    public void setCreditOffer(CreditOffer creditOffer) {
        this.creditOffer = creditOffer;
    }

    public PaymentSchedule getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
