package com.ark.arkassessment.service;

import com.ark.arkassessment.controller.ClientController;
import com.ark.arkassessment.model.Client;
import com.ark.arkassessment.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client createClient(Client client){
        return clientRepository.save(client);
    }
}
