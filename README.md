# Medical Healthcare Booking API (Spring Boot)

This project is a Java Spring Boot backend for healthcare management using **Spring Data JPA**, **Hibernate**, and **MySQL**.

## Features

- Manage **Doctors** and assign them to multiple hospitals.
- Manage **Patients**.
- Manage **Hospitals**.
- Create **Bookings** where a patient books an appointment with a doctor at a selected hospital.
- Validate that a booking can only be created if the doctor is assigned to that hospital.

## Tech stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA / Hibernate
- MySQL
- Maven

## Run locally

1. Create a MySQL database:
   ```sql
   CREATE DATABASE healthcare_db;
   ```
2. Update DB credentials in `src/main/resources/application.properties`.
3. Run the app:
   ```bash
   mvn spring-boot:run
   ```

## Main REST APIs

### Doctors
- `POST /api/doctors` create doctor
- `GET /api/doctors` list doctors
- `POST /api/doctors/{doctorId}/hospitals/{hospitalId}` assign doctor to hospital

### Patients
- `POST /api/patients` create patient
- `GET /api/patients` list patients

### Hospitals
- `POST /api/hospitals` create hospital
- `GET /api/hospitals` list hospitals

### Bookings
- `POST /api/bookings` create appointment booking
- `GET /api/bookings` list all bookings
- `GET /api/bookings/patient/{patientId}` list by patient
- `GET /api/bookings/hospital/{hospitalId}` list by hospital

### Booking request JSON
```json
{
  "patientId": 1,
  "doctorId": 1,
  "hospitalId": 2,
  "appointmentAt": "2026-03-12T11:00:00"
}
```
