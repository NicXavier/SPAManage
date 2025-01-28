package com.spamanage.demo.repository;

import com.spamanage.demo.enums.PackageStatus;
import com.spamanage.demo.model.ServicePackage;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicePackageRepository extends JpaRepository<ServicePackage, Long> {
    
        //Buscar pacotes com base em nome
    List<ServicePackage> findByPackageNameContaining(String packageName);

    //Buscar pacotes com base em status
    List<ServicePackage> findByPackageStatus(PackageStatus status);

    //Buscar pacotes com preço superior a um determinado valor
    List<ServicePackage> findByPackagePriceAmountGreaterThan(BigDecimal price);

    //Buscar pacotes com duração menor ou igual ao valor informado
    List<ServicePackage> findByPackageDurationMinutesLessThanEqual(Integer duration);
}
