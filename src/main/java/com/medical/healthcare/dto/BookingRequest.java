package com.medical.healthcare.dto;

import java.time.LocalDateTime;

public class BookingRequest {
    private Long patientId;
    private Long doctorId;
    private Long hospitalId;
    private LocalDateTime appointmentAt;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public LocalDateTime getAppointmentAt() {
        return appointmentAt;
    }

    public void setAppointmentAt(LocalDateTime appointmentAt) {
        this.appointmentAt = appointmentAt;
    }
}
