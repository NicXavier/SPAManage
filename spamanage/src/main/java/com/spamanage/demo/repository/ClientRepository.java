package com.spamanage.demo.repository;

import com.spamanage.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
    //Buscar cliente por nome
    List<Client> findByClientNameContainingIgnoreCase(String clientName);

    //Buscar cliente por CPF
    Client findByCpf(String cpf);
}
