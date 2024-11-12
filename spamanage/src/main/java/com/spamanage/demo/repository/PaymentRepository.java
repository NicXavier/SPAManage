package com.spamanage.demo.repository;

import com.spamanage.demo.model.payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository extends JpaRepository<Payment, Long>{
    
}
