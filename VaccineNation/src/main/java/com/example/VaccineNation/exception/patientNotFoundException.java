package com.example.VaccineNation.exception;

public class patientNotFoundException extends RuntimeException{
    public patientNotFoundException(String message){
        super(message);
    }
}
