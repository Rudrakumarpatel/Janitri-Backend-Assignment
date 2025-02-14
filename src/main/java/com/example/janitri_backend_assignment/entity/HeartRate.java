package com.example.janitri_backend_assignment.entity;

import jakarta.persistence.*;
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
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private int bpm; // Heart rate in beats per minute

    private LocalDateTime recordedAt = LocalDateTime.now();
}
