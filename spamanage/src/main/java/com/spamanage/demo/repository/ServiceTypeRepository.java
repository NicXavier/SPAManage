package com.spamanage.demo.repository;

import com.spamanage.demo.model.ServiceType;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long>{
    
    //Buscar por tipo de serviço
    List<ServiceType> findByServiceTypeContainingIgnoreCase(String serviceType);

    //Buscar por faixa de preço
    List<ServiceType> findByServicePriceBetween(Double minPrice, Double maxPrice);

    //Buscar por duração do serviço
    List<ServiceType> findByServiceDurationGreaterThanEqual(Integer duration);
    List<ServiceType> findByServiceDurationLessThanEqual(Integer duration);

    //Verificar se existe um serviço com o nome especificado
    boolean existsByServiceType(String serviceType);

    //Contar todos os serviços cadastrados
    long count();
    
}
