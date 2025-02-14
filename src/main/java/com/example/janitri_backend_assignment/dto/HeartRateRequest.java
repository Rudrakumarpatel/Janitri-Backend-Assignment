package com.example.janitri_backend_assignment.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class HeartRateRequest {
    @NotNull(message = "Patient ID is required")
    private Long patientId;
    @Min(value = 30, message = "Please Enter Valid bpm (at Least 30)")
    private int bpm;
    private LocalDateTime recordedAt;

    // Getters and setters
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
}