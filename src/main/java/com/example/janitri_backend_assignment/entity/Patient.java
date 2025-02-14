package com.example.janitri_backend_assignment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Patient name is required")
    private String name;

    @NotNull(message = "Patient age is required")
    private int age;

    @NotBlank(message = "Patient address is required")
    private String address;

    @NotBlank(message = "Patient gender is required")
    private String gender;

}
