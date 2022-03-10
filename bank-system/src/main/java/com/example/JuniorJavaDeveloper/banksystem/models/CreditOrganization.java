package com.example.JuniorJavaDeveloper.banksystem.models;

import java.util.UUID;

public interface CreditOrganization {

    default UUID getId() {
        return null;
    }

    default String getName() {
        return null;
    }

}
