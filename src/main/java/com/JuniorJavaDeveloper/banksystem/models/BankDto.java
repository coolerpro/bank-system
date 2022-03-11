package com.JuniorJavaDeveloper.banksystem.models;

import java.util.UUID;

public class BankDto implements CreditOrganization {

    private UUID id;
    private String name;
    private String inn;
    private String bic;

    public BankDto()  {
    }

    public BankDto(UUID id, String name, String inn, String bic) {
        this.id = id;
        this.name = name;
        this.inn = inn;
        this.bic = bic;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
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
}
