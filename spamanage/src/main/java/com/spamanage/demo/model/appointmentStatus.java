package com.spamanage.demo.model;

import org.springframework.core.metrics.ApplicationStartup;

import lombok.Getter;

@Getter
public class appointmentStatus {

    SHEDULED("O agendamento está marcado."),
    COMPLETED("O agendamento foi concluído com sucesso."),
    CANCELED("O agendamento foi cancelado.");
    
    private final String message;

    appointmentStatus(String message) {
        this.message = message;
    }
}
