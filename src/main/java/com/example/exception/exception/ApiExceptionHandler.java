package com.example.exception.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.Locale;

@ControllerAdvice
public class ApiExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(AgeIsNotValidException.class)
    public ResponseEntity handleAgeError(AgeIsNotValidException a) {
        Locale locale = LocaleContextHolder.getLocale();
        String errorCode = a.getErrorCode();
        String errorMessage = messageSource.getMessage(errorCode, null, locale);
        String[] httpErrorCode = errorMessage.split(" | ");
        ApiErrorResponse ap = new ApiErrorResponse();
        ap.setErrorCode(Integer.valueOf(errorCode));
        ap.setMessage(errorMessage);
        ap.setTimestamp(Instant.now());
        return ResponseEntity.status(Integer.valueOf(httpErrorCode[0])).body(ap);

//        return new ResponseEntity(new ApiErrorResponse(100,message, Instant.now()) );
//        System.out.println(Integer.valueOf(httpErrorCode[0]));
//        return ResponseEntity.ok(ap);
    }


}
