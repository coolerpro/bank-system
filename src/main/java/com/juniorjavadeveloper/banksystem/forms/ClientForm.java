package com.juniorjavadeveloper.banksystem.forms;

import com.juniorjavadeveloper.banksystem.entity.Client;
import com.juniorjavadeveloper.banksystem.entity.Credit;

import java.util.List;

public class ClientForm extends Form{
    private Client client;
    private List<Client> clientList;
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

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
}
