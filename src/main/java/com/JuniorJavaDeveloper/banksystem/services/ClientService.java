package com.JuniorJavaDeveloper.banksystem.services;

import com.JuniorJavaDeveloper.banksystem.models.ClientDto;
import com.JuniorJavaDeveloper.banksystem.models.entity.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    List<ClientDto> clientsList();
    ClientDto getClient(UUID id);
    void save(ClientDto clientNew);
    void update(ClientDto clientEdit);
    void delete(UUID id);

    ClientDto convertToDto(Client client);
    Client convertToEnt(ClientDto clientDto);
}
