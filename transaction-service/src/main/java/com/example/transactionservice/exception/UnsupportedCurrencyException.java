// src/main/java/com/example/transactionservice/exception/UnsupportedCurrencyException.java
package com.example.transactionservice.exception;

public class UnsupportedCurrencyException extends RuntimeException {
    public UnsupportedCurrencyException(String message) {
        super(message);
    }
}
