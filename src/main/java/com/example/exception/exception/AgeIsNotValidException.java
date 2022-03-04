package com.example.exception.exception;

import org.springframework.http.HttpStatus;

public class AgeIsNotValidException extends RuntimeException{
    private String errorCode;
    public AgeIsNotValidException(String errorCode){
        super(errorCode);
        this.errorCode = errorCode;
    }

    public String getErrorCode(){ return errorCode;}


}
