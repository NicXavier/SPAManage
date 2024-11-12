package com.spamanage.demo.repository;

import com.spamanage.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository extends JpaRepository<Client, Long>{
    
}
