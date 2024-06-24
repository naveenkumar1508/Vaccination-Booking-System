package com.example.VaccineNation.service;

import com.example.VaccineNation.exception.patientNotFoundException;
import com.example.VaccineNation.model.Patient;
import com.example.VaccineNation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;
    public Patient addPatient(Patient patient) {
         return patientRepository.save(patient);    //Saving patient(Object) to the dataBase returns Saved Patient

    }

    public Patient getPatient(int id){
      Optional<Patient> patientOptional =  patientRepository.findById(id); //searches baased on primary key

      if(patientOptional.isEmpty()){

          throw new patientNotFoundException("Invalid Patient id");
      }

      Patient patient = patientOptional.get();
      return patient;
    }
}
