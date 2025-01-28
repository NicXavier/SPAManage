package com.spamanage.demo.controller;

import com.spamanage.demo.model.ServiceType;
import com.spamanage.demo.repository.ServiceTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/service-types")
public class ServiceTypeController {
    
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @PostMapping
    public ResponseEntity<ServiceType> createServiceTyoe(@Valid @RequestBody ServiceType serviceType) {
        ServiceType createdServiceType = serviceTypeRepository.save(serviceType);
        return ResponseEntity.ok(createdServiceType);
    }

    @GetMapping
    public ResponseEntity<List<ServiceType>> getAllServiceTypes() {
        List<ServiceType> serviceTypes = serviceTypeRepository.findAll();
        return ResponseEntity.ok(serviceTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceType> getServiceTypeById(@PathVariable Long id) {
        return serviceTypeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceType> updateServiceType(@PathVariable Long id, @Valid @RequestBody ServiceType updatedServiceType) {
        return serviceTypeRepository.findById(id).map(existingServiceType -> {
            existingServiceType.setServiceType(updatedServiceType.getServiceType());
            existingServiceType.setServiceDescription(updatedServiceType.getServiceDescription());
            existingServiceType.setServiceDuration(updatedServiceType.getServiceDuration());
            existingServiceType.setServicePrice(updatedServiceType.getServicePrice());
            serviceTypeRepository.save(existingServiceType);
            return ResponseEntity.ok(existingServiceType);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceType(@PathVariable Long id) {
        if(!serviceTypeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        serviceTypeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
