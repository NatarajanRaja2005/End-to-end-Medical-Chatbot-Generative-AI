package com.medical.healthcare.controller;

import com.medical.healthcare.model.Doctor;
import com.medical.healthcare.model.Hospital;
import com.medical.healthcare.repository.DoctorRepository;
import com.medical.healthcare.repository.HospitalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;

    public DoctorController(DoctorRepository doctorRepository, HospitalRepository hospitalRepository) {
        this.doctorRepository = doctorRepository;
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @PostMapping
    public Doctor create(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @PostMapping("/{doctorId}/hospitals/{hospitalId}")
    public Doctor assignDoctorToHospital(@PathVariable Long doctorId, @PathVariable Long hospitalId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new IllegalArgumentException("Hospital not found"));

        doctor.getHospitals().add(hospital);
        return doctorRepository.save(doctor);
    }
}
