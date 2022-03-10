package com.example.JuniorJavaDeveloper.banksystem.services.impl;

import com.example.JuniorJavaDeveloper.banksystem.models.ClientDto;
import com.example.JuniorJavaDeveloper.banksystem.models.entity.Client;
import com.example.JuniorJavaDeveloper.banksystem.repository.ClientRepository;
import com.example.JuniorJavaDeveloper.banksystem.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ClientDto> clientsList(){

        List<ClientDto> clientsDto = new ArrayList<>();

        List<Client> clientsEnt = clientRepository.findAll();

        for (Client client:clientsEnt) {
            clientsDto.add(convertToDto(client));
        }

        return clientsDto;
    }

    @Override
    public ClientDto getClient(UUID id){
        return convertToDto(clientRepository.getById(id));
    }

    @Override
    public void save(ClientDto clientNew) {
        clientRepository.saveAndFlush(convertToEnt(clientNew));
    }

    @Override
    public void update(ClientDto clientEdit) {
        clientRepository.saveAndFlush(convertToEnt(clientEdit));
    }

    @Override
    public void delete(UUID id){
        clientRepository.delete(clientRepository.getById(id));
    }



    public ClientDto convertToDto(Client client){

        ClientDto clientDto = new ClientDto();

        clientDto.setId(client.getId());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setFatherName(client.getFatherName());
        clientDto.setEmail(client.getEmail());
        clientDto.setPasportNumber(client.getPasportNumber());
        clientDto.setPhoneNumber(client.getPhoneNumber());

        return clientDto;

    }

    public Client convertToEnt(ClientDto clientDto){

        Client client = new Client();

        client.setId(clientDto.getId());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setFatherName(clientDto.getFatherName());
        client.setEmail(clientDto.getEmail());
        client.setPasportNumber(clientDto.getPasportNumber());
        client.setPhoneNumber(clientDto.getPhoneNumber());

        return client;

    }
}
