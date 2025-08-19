package com.JuniorJavaDeveloper.banksystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "inn")
    private String inn;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bic")
    private String bic;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(id, bank.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
