package com.spamanage.demo.repository;

import com.spamanage.demo.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceTypeRepository extends JpaRepository<ServiceType, Long>{
    
}
