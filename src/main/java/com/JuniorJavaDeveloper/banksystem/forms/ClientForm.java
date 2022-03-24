package com.JuniorJavaDeveloper.banksystem.forms;

import com.JuniorJavaDeveloper.banksystem.entity.Client;
import com.JuniorJavaDeveloper.banksystem.entity.Credit;

import java.util.List;

public class ClientForm extends Form{
    private Client client;
    private List<Client> clientsList;
    private List<Credit> creditList;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Credit> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<Credit> creditList) {
        this.creditList = creditList;
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }
}
