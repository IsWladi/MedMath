package com.iswladi.apimedmath.apimedmath.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.iswladi.apimedmath.apimedmath.dto.ErrorDTO;
import com.iswladi.apimedmath.apimedmath.exception.RequestException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(RequestException.class)
    public ResponseEntity<ErrorDTO> requestExceptionHandler(RequestException e) {
        ErrorDTO error = new ErrorDTO(e.getMessage());
        return new ResponseEntity<>(error, e.getStatus());
    }
}
