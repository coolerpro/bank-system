package com.JuniorJavaDeveloper.banksystem.services;

import com.JuniorJavaDeveloper.banksystem.models.entity.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    List<Client> clientsList();

    Client getClient(UUID id);

    void save(Client clientNew);

    void update(Client clientEdit);

    void delete(UUID id);
}
