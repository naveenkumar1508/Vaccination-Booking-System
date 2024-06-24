package com.example.VaccineNation.controller;

import com.example.VaccineNation.model.Appointment;
import com.example.VaccineNation.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestParam("pid") int patientId, @RequestParam("did") int doctorId){


        try {
            Appointment bookAppointment = appointmentService.bookAppointment(patientId, doctorId);
            return new ResponseEntity(bookAppointment,HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
