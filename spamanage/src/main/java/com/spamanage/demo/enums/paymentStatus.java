package com.spamanage.demo.enums;

import lombok.Getter;

@Getter
public class PaymentStatus {
    
    PAID("Pago"),
    PENDING("Pendente"),
    CANCELED("Cancelado");

    private final String description;

    paymentStatus(String description) {
        this.description = description;
    }
}
