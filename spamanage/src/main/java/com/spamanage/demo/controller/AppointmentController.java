package com.spamanage.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spamanage.demo.model.Appointment;
import com.spamanage.demo.repository.AppointmentRepository;
import com.spamanage.demo.enums.AppointmentStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    
    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    
    @GetMapping("/client/{clientID}")
    public List<Appointment> getAppointmentsByClient(@PathVariable Long clientId) {
        return appointmentRepository.findByClientId(clientId);
    }   

    @PatchMapping("/{id}/status")
    public Appointment updateAppointmentStatus (@PathVariable Long id, @RequestBody AppointmentStatus status) {
        return appointmentRepository.findById(id).map(appointment -> {
            appointment.setStatus(status);
            return appointmentRepository.save(appointment);
        }).orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }
    
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new RuntimeException("Agendamento não encontrado")
        }
        appointmentRepository.deleteById(id);
    }
}
