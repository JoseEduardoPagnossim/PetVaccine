package com.josespagnossim.petvaccine.exceptions.pets;

public class PetNotFound extends RuntimeException {
    public PetNotFound(String message) {
        super(message);
    }
}
