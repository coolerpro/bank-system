package com.juniorjavadeveloper.banksystem.services.impl;

import com.juniorjavadeveloper.banksystem.entity.Client;
import com.juniorjavadeveloper.banksystem.repository.ClientRepository;
import com.juniorjavadeveloper.banksystem.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements MainService<Client> {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(UUID id) {
        return clientRepository.getById(id);
    }

    @Override
    public void save(Client clientNew) {
        clientRepository.save(clientNew);
    }

    @Override
    public void delete(UUID id) {
        clientRepository.delete(clientRepository.getById(id));
    }
}
