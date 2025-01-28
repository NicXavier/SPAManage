package com.spamanage.demo.controller;

import com.spamanage.demo.model.ServicePackage;
import com.spamanage.demo.enums.PackageStatus;
import com.spamanage.demo.repository.ServicePackageRepository;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/sevice-packages")
public class ServicePackageController {
    
    @Autowired
    private ServicePackageRepository servicePackageRepository;

    @PostMapping
    public ResponseEntity<ServicePackage> createServicePackage(@Valid @RequestBody ServicePackage servicePackage, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //Retornar erros de validação
            return ResponseEntity.badRequest().body(null);
        }

        ServicePackage createdServicePackage = servicePackageRepository.save(servicePackage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdServicePackage);

    }

    @GetMapping
    public ResponseEntity<List<ServicePackage>> getAllServicePackages() {
        List<ServicePackage> packages = servicePackageRepository.findAll();
        return ResponseEntity.ok(packages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicePackage> getServicePackageByI(@PathVariable Long id) {
        Optional<ServicePackage> servicePackage = servicePackageRepository.findById(id);
        return servicePackage.map(ResponseEntity::ok)    
                            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicePackage> updateServicePackage(@PathVariable Long id, @Valid @RequestBody ServicePackage servicePackage, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //retornar erros de validação
            return ResponseEntity.badRequest().body(null);
        }
        if (!servicePackageRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        servicePackage.setPackageId(id);
        ServicePackage updatedPackage = servicePackageRepository.save(servicePackage);
        return ResponseEntity.ok(updatedPackage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicePackage(@PathVariable Long id) {
        if(!servicePackageRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        servicePackageRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Filtro por nome 
    @GetMapping("/search/name")
    public ResponseEntity<List<ServicePackage>> searchByName(@RequestParam String packageName) {
        List<ServicePackage> packages = servicePackageRepository.findByPackageNameContaining(packageName);
        return ResponseEntity.ok(packages);
    }

    //Filtro por status
    @GetMapping("/search/status")
    public ResponseEntity<List<ServicePackage>> searchByStatus(@RequestParam PackageStatus status) {
        List<ServicePackage> packages = servicePackageRepository.findByPackageStatus(status);
        return ResponseEntity.ok(packages);
    }

    //Filtro por preço
    @GetMapping("/search/price")
    public ResponseEntity<List<ServicePackage>> searchByPrice(@RequestParam BigDecimal price) {
        List<ServicePackage> packages = servicePackageRepository.findByPackagePriceAmountGreaterThan(null);
        return ResponseEntity.ok(packages);
    }
    
    //Filtro por duração
    @GetMapping("/search/duration")
    public ResponseEntity<List<ServicePackage>> searchByDuration(@RequestParam Integer duration) {
        List<ServicePackage> packages = servicePackageRepository.findByPackageDurationMinutesLessThanEqual(duration);
        return ResponseEntity.ok(packages);
    }

}
