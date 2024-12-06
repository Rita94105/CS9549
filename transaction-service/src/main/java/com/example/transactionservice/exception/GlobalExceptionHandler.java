// src/main/java/com/example/transactionservice/exception/GlobalExceptionHandler.java
package com.example.transactionservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UnsupportedCurrencyException.class)
    public ResponseEntity<?> handleUnsupportedCurrency(UnsupportedCurrencyException e) {
        // QR3: Prompt users with clear messages for any invalid input
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<?> handleInsufficientFunds(InsufficientFundsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    // Handle other exceptions (e.g., MethodArgumentNotValidException)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
