package com.example.janitri_backend_assignment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "heart_rates")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeartRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Patient is required")
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @NotNull(message = "Patient is required")
    @Min(value = 30, message = "Please Enter Valid bpm (at Least 30)")
    private int bpm; // Heart rate in beats per minute


    private LocalDateTime recordedAt = LocalDateTime.now();
}
