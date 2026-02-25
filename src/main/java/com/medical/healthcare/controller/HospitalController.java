package com.medical.healthcare.controller;

import com.medical.healthcare.model.Hospital;
import com.medical.healthcare.repository.HospitalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping
    public List<Hospital> findAll() {
        return hospitalRepository.findAll();
    }

    @PostMapping
    public Hospital create(@RequestBody Hospital hospital) {
        return hospitalRepository.save(hospital);
    }
}
