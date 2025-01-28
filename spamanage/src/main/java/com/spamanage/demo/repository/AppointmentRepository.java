package com.spamanage.demo.repository;

import com.spamanage.demo.model.Appointment;
import com.spamanage.demo.enums.AppointmentStatus;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    
    //Busca todos os agendamentos de um cliente específico
    List<Appointment> findByClientId(Long clientId);

    //Busca todos os agendamentos por status
    List<Appointment> findByStatus(AppointmentStatus status);
}
