// src/main/java/com/example/transactionservice/exception/InsufficientFundsException.java
package com.example.transactionservice.exception;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
