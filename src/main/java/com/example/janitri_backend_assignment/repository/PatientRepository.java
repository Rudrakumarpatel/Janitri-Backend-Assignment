package com.example.janitri_backend_assignment.repository;

import com.example.janitri_backend_assignment.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
