package com.medical.healthcare.controller;

import com.medical.healthcare.dto.BookingRequest;
import com.medical.healthcare.model.Booking;
import com.medical.healthcare.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/patient/{patientId}")
    public List<Booking> getPatientBookings(@PathVariable Long patientId) {
        return bookingService.getBookingsByPatient(patientId);
    }

    @GetMapping("/hospital/{hospitalId}")
    public List<Booking> getHospitalBookings(@PathVariable Long hospitalId) {
        return bookingService.getBookingsByHospital(hospitalId);
    }

    @PostMapping
    public Booking createBooking(@RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }
}
