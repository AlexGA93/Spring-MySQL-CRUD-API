package com.alexga93.fullstackbackend.exception;

public class UserNotFoundExcepction extends RuntimeException {
    // public method called by 'orElseThrow'
    public UserNotFoundExcepction(Long id){
        super("Could not found the user with id: "+id);
    }
}
