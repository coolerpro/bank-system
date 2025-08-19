package com.JuniorJavaDeveloper.banksystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "credit")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "clientid")
    private Client client;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "banktid")
    private Bank bank;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "creditofferid")
    private CreditOffer creditOffer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "paymentscheduleid")
    private PaymentSchedule paymentSchedule;

    @NotNull
    @Column(name = "sum")
    private BigDecimal sum;

    @NotNull
    @Column(name = "sumbody")
    private BigDecimal sumBody;

    @NotNull
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return Objects.equals(id, credit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
