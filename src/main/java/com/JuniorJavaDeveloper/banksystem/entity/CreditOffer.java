package com.JuniorJavaDeveloper.banksystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "creditoffer")
public class CreditOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @NotNull
    @Column(name = "creditlimit")
    private BigDecimal creditLimit;

    @NotNull
    @Column(name = "interestrate")
    private BigDecimal interestRate;

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getName(){
        String bankName = bank != null ? bank.getName() : "Unknown bank";
        return bankName + " " + getInterestRate() + " " + getCreditLimit();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditOffer that = (CreditOffer) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
