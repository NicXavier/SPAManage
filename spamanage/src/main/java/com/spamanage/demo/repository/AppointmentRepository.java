package com.spamanage.demo.repository;

import com.spamanage.demo.model.Appointment; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepository extends JpaRepository<Appointment , Long>{
    
}
