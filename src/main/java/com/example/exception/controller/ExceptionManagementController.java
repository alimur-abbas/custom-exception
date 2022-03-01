package com.example.exception.controller;

import com.example.exception.exception.AgeIsNotValidException;
import com.example.exception.model.Applicant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionManagementController {



    @PostMapping("/check")
    public ResponseEntity saveUser(@RequestBody Applicant app){
        if(app.getAge()<=18){
            throw new AgeIsNotValidException();
        }
       return (ResponseEntity) ResponseEntity.ok();
    }

}
