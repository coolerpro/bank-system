package com.JuniorJavaDeveloper.banksystem.services.impl;

import com.JuniorJavaDeveloper.banksystem.models.entity.Client;
import com.JuniorJavaDeveloper.banksystem.repository.ClientRepository;
import com.JuniorJavaDeveloper.banksystem.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> clientsList() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(UUID id) {
        return clientRepository.getById(id);
    }

    @Override
    public void save(Client clientNew) {
        clientRepository.saveAndFlush(clientNew);
    }

    @Override
    public void update(Client clientEdit) {
        clientRepository.saveAndFlush(clientEdit);
    }

    @Override
    public void delete(UUID id) {
        clientRepository.delete(clientRepository.getById(id));
    }
}
