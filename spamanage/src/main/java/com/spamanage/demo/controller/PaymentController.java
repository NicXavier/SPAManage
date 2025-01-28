package com.spamanage.demo.controller;

import com.spamanage.demo.model.Payment;
import com.spamanage.demo.enums.PaymentStatus;
import com.spamanage.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping('/payments')
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping
    public Payment createPayment(@PathVariable Payment payment) {
        return paymentRepository.save(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        retunr paymentRepository.findAll();
    }
    
    @GetMapping("/status{status}")
    public List<Payment> getPaymentsByStatus(@PathVariable PaymentStatus status) {
        return paymentRepository.findByPaymentStatus(status);
    }

    @GetMapping("/id{id}")
    public Payment getPaymentsById(@PathVariable Long id) {
        //verificar se existe o pagamento
        Optional<Payment> payment = paymentRepository,findById(id);
        if(payment.isPresent()) {
            return payment.get();
        } else {
            throw new RuntimeException("Pagamento não encontrado");        
        }
    }

    @PatchMapping("/{id}/status")
    public Payment updatedPaymentStatus(@PathVariable Long id, @RequestBody PaymentStatus status) {
        return paymentRepository.findById(id).map(payment -> {
            payment.setPaymentStatus(status);
            return paymentRepository.save(payment);
        }).orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Pagamento não encontrado");
        }
        paymentRepository.deleteById(id);
    }
}
