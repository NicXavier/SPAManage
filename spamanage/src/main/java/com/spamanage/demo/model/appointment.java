package com.spamanage.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
public class appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne // muitos agendamentos para um cliente
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne // muitos agendamentos para um serviço
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @ManyToOne // muitos agendamentos para um terapeuta
    @JoinColumn(name = "therapist_id", nullable = false)
    private Therapist therapist;

    @Column(name = "appointment_date_time", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "appointments_status", nullable = false)
    private ConsultantionStatus status;

    @Column(name = "appointment_notes", nullable = false)
    private String appointmentNotes;  
       
}
