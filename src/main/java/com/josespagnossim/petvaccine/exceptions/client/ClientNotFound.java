package com.josespagnossim.petvaccine.exceptions.client;

public class ClientNotFound extends RuntimeException{
    public ClientNotFound(String message){
        super(message);
    }
}
