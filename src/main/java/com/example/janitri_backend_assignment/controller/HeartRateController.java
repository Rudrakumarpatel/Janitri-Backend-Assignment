package com.example.janitri_backend_assignment.controller;

import com.example.janitri_backend_assignment.dto.HeartRateRequest;
import com.example.janitri_backend_assignment.entity.HeartRate;
import com.example.janitri_backend_assignment.entity.Patient;
import com.example.janitri_backend_assignment.service.HeartRateService;
import com.example.janitri_backend_assignment.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heart-rates")
public class HeartRateController {
    @Autowired
    private HeartRateService heartRateService;

    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity<?> recordHeartRate(@Valid @RequestBody HeartRateRequest heartRateRequest) {
        // Fetch the Patient entity by patientId
        Patient patient = patientService.getPatientsById(heartRateRequest.getPatientId());

        // If patient not found, return 404 error
        if (patient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }

        // Create the HeartRate entity and set the fields
        HeartRate heartRate = new HeartRate();
        heartRate.setPatient(patient);
        heartRate.setBpm(heartRateRequest.getBpm());
        heartRate.setRecordedAt(heartRateRequest.getRecordedAt());

        // Save the heart rate entity
        return ResponseEntity.ok(heartRateService.recordHeartRate(heartRate));
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<?> getHeartRates(@PathVariable Long patientId) {
        if (patientService.getPatientsById(patientId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }
        return ResponseEntity.ok(heartRateService.getHeartRatesByPatientId(patientId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<HeartRate>> getAllHeartRates() {
        List<HeartRate> heartRates = heartRateService.getAllHeartRates();
        return ResponseEntity.ok(heartRates);
    }
}
