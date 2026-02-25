package com.medical.healthcare.service;

import com.medical.healthcare.dto.BookingRequest;
import com.medical.healthcare.model.Booking;
import com.medical.healthcare.model.Doctor;
import com.medical.healthcare.model.Hospital;
import com.medical.healthcare.model.Patient;
import com.medical.healthcare.repository.BookingRepository;
import com.medical.healthcare.repository.DoctorRepository;
import com.medical.healthcare.repository.HospitalRepository;
import com.medical.healthcare.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;

    public BookingService(BookingRepository bookingRepository,
                          PatientRepository patientRepository,
                          DoctorRepository doctorRepository,
                          HospitalRepository hospitalRepository) {
        this.bookingRepository = bookingRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.hospitalRepository = hospitalRepository;
    }

    @Transactional
    public Booking createBooking(BookingRequest request) {
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        Hospital hospital = hospitalRepository.findById(request.getHospitalId())
                .orElseThrow(() -> new IllegalArgumentException("Hospital not found"));

        if (!doctor.getHospitals().contains(hospital)) {
            throw new IllegalArgumentException("Doctor is not assigned to this hospital");
        }

        Booking booking = new Booking();
        booking.setPatient(patient);
        booking.setDoctor(doctor);
        booking.setHospital(hospital);
        booking.setAppointmentAt(request.getAppointmentAt());

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingsByPatient(Long patientId) {
        return bookingRepository.findByPatientId(patientId);
    }

    public List<Booking> getBookingsByHospital(Long hospitalId) {
        return bookingRepository.findByHospitalId(hospitalId);
    }
}
