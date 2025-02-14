package com.example.janitri_backend_assignment.service;

import com.example.janitri_backend_assignment.entity.Patient;
import com.example.janitri_backend_assignment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }
    public Patient getPatientsById(Long patientId) {
        return patientRepository.findById(patientId).orElse(null); // Return null if patient doesn't exist
    }

}
