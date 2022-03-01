package com.example.exception.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
@PropertySource("message.properties")
public class ApiExceptionHandler {
    @Value("${100}")
 private String message;
    @ExceptionHandler(AgeIsNotValidException.class)
    public ResponseEntity handleAgeError(){
        ApiErrorResponse ap = new ApiErrorResponse();
        ap.setStatus(100);
        ap.setMessage(message);
        ap.setTimestamp(Instant.now());
        return ResponseEntity.ok(ap);

//        return new ResponseEntity(new ApiErrorResponse(100,message, Instant.now()) );
    }


}
