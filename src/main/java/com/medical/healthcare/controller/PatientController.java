package com.medical.healthcare.controller;

import com.medical.healthcare.model.Patient;
import com.medical.healthcare.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @PostMapping
    public Patient create(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }
}
