package com.spamanage.demo.repository;

import com.spamanage.demo.model.servicePackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ServicePackageRepository extends JpaRepository<ServicePackage, Long> {
    
}
