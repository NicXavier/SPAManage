package com.spamanage.demo.model;

import com.spamanage.demo.enums.appointmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Future;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne // muitos agendamentos para um cliente
    @JoinColumn(name = "client_id", nullable = false)
    @NotNull(message = "É obrigatório preencher o campo cliente.")
    private Client client;

    @ManyToOne // muitos agendamentos para um serviço
    @JoinColumn(name = "service_id", nullable = false)
    @NotNull(message = "É obrigatório preencher o serviço desejado.")
    private ServiceType service;

    @ManyToOne // muitos agendamentos para um terapeuta
    @JoinColumn(name = "therapist_id", nullable = false)
    @NotNull(message = "É obrigatório preencher o campo terapeuta.")
    private therapist therapist;

    @NotNull(message = "A data e hora do agendamento não podem ser nulas.")
    @Future(message = "O agendamento deve ser para uma data e hora futura.")
    @Column(name = "appointment_date_time", nullable = false)
    private LocalDateTime appointmentDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "appointments_status", nullable = false)
    @NotNull(message = "Agendamento inválido. Tente outra vez.")
    private appointmentStatus status;

    @Column(name = "appointment_notes", nullable = false)
    @Size(max = 500, message = "As observações não podem ter mais de 500 caracteres.")
    private String appointmentNotes;  
       
}
