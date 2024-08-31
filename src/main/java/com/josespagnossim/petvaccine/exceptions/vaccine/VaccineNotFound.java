package com.josespagnossim.petvaccine.exceptions.vaccine;

public class VaccineNotFound extends RuntimeException{

    public VaccineNotFound(String message){
        super(message);
    }
}
