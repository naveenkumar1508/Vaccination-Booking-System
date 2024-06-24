package com.example.VaccineNation.service;

import com.example.VaccineNation.exception.doctorNotFoundException;
import com.example.VaccineNation.model.Doctor;
import com.example.VaccineNation.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;



    public String addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        return "Doctor saved Sucessfully";
    }

    public Doctor getDoctor(int id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);

        if(doctorOptional.isEmpty()){
            throw new doctorNotFoundException("Invalid doctor id");
        }

        Doctor doctor = doctorOptional.get();
        return doctor;
    }


    public String deleteDoctor(int id) {
        doctorRepository.deleteById(id);

        return "Doctor has been Deleted";

    }
}
