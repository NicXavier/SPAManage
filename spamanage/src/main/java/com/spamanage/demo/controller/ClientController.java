package com.spamanage.demo.controller;

import com.spamanage.demo.model.Client;
import com.spamanage.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }
    
    GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientRepository.findById(id)
                .orElse(() -> new RuntimeException("Cliente não encontrado"));
    }

    @GetMapping("/name/{clientName}")
    public Client getClientByName(@PathVariable String clientName) {
        return clientRepository.findByClientNameContainingIgnoreCase(clientName);
    }

    @GetMapping("/cpf{cpf}")
    public Client getClientByCpf(@PathVariable String cpf) {
        return clientRepository.findByCpf(cpf);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client updaClient) {
        return clientRepository.findById(id).map(client -> {
            client.setClientName(updatedClient.getClientName());
            client.setCpf(updatedClient.getClientCpf());
            client.setEmail(updatedClient.getEmail());
            client.setPhone(updatedClient.getPhone());
            client.setHomeAddress(updatedClient.getHomeAddress());
            client.setBirthDate(updatedClient.getBirthDate());
            return clientRepository.save(client);
        }).orElse(() -> new RuntimeException("Cliente não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        clientRepository.deleteById(id);
    }
    
}
