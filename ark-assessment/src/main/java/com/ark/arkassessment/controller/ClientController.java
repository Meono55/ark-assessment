package com.ark.arkassessment.controller;

import com.ark.arkassessment.model.Client;
import com.ark.arkassessment.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clientList = clientService.getAllClients();

        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Client newClient = clientService.createClient(client);

        return new ResponseEntity<>(newClient, HttpStatus.OK);
    }
}
