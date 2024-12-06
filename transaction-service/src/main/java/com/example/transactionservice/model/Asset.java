// src/main/java/com/example/transactionservice/model/Asset.java
package com.example.transactionservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "assets")
public class Asset {
    @Id
    private String id;
    private String currencyCode;
    private BigDecimal amount;
    private String username; // Reference to User by username

    // Getters and Setters
}
