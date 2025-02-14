package com.example.janitri_backend_assignment.service;

import com.example.janitri_backend_assignment.entity.HeartRate;
import com.example.janitri_backend_assignment.repository.HeartRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeartRateService {
    @Autowired
    private HeartRateRepository heartRateRepository;

    public HeartRate recordHeartRate(HeartRate heartRate) {
        return heartRateRepository.save(heartRate);
    }

    public List<HeartRate> getHeartRatesByPatientId(Long patientId) {
        return heartRateRepository.findByPatientId(patientId);
    }
    public List<HeartRate> getAllHeartRates() {
        return heartRateRepository.findAll();
    }
}
