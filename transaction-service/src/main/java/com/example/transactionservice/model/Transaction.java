// src/main/java/com/example/transactionservice/model/Transaction.java
package com.example.transactionservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String type; // "EXCHANGE" or "PURCHASE"
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private String username; // Reference to User by username

    // Getters and Setters
}
