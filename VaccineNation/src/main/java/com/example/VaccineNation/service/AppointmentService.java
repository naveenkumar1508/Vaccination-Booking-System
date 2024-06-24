package com.example.VaccineNation.service;

import com.example.VaccineNation.Enum.AppointmentStatus;
import com.example.VaccineNation.exception.doctorNotFoundException;
import com.example.VaccineNation.exception.patientNotFoundException;
import com.example.VaccineNation.model.Appointment;
import com.example.VaccineNation.model.Doctor;
import com.example.VaccineNation.model.Patient;
import com.example.VaccineNation.repository.AppointmentRepository;
import com.example.VaccineNation.repository.DoctorRepository;
import com.example.VaccineNation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    public Appointment bookAppointment(int patientId, int doctorId) {

        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if(patientOptional.isEmpty()){
            throw  new patientNotFoundException("Invalid PatientId");
        }

        Optional<Doctor> doctorOptional = doctorRepository.findById(patientId);
        if(doctorOptional.isEmpty()){
            throw  new doctorNotFoundException("Invalid DoctorId");
        }

        Patient patient = patientOptional.get();
        Doctor doctor = doctorOptional.get();

        //Book the appointment
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setStatus(AppointmentStatus.BOOKED);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        return appointmentRepository.save(appointment);



    }
}
