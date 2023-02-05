package com.alexga93.fullstackbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserNotFoundAdvice {
    // code for handling a exception
    // An object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.
    @ResponseBody
    @ExceptionHandler(UserNotFoundExcepction.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandler(UserNotFoundExcepction excepction){
        Map<String, String> errorMap = new HashMap<>();
        // update a pair key-value exception with the exception message
        errorMap.put("errorMessage", excepction.getMessage());

        return errorMap;
    }
}
