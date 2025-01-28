package com.spamanage.demo.repository;

import com.spamanage.demo.enums.PaymentStatus;
import com.spamanage.demo.model.Payment;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
    
    //Buscar pagamentos por status
    List<Payment> findByPaymentStatus(PaymentStatus paymentStatus);

    //Buscar pagamentos por tipo
    List<Payment> findByPaymentType(String paymentType);

    //Buscar pagamentos por valor
    List<Payment> finByPaymentAmountGreaterThan(BigDecimal amount);
}
