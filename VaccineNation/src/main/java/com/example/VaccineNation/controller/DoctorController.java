package com.example.VaccineNation.controller;

import com.example.VaccineNation.model.Doctor;
import com.example.VaccineNation.model.Patient;
import com.example.VaccineNation.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
           return doctorService.addDoctor(doctor);
    }

    @GetMapping("/get")
    public Doctor getDoctor(@RequestParam("id") int id){
        return doctorService.getDoctor(id);
    }



    @DeleteMapping("/delete")
    public String deleteDoctor(@RequestParam("id") int id){
        return doctorService.deleteDoctor(id);

    }
}
