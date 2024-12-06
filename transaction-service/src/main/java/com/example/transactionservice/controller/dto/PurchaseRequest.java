// src/main/java/com/example/transactionservice/controller/dto/PurchaseRequest.java
package com.example.transactionservice.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class PurchaseRequest {
    @NotBlank
    private String currencyCode;

    @NotNull
    @Positive
    private BigDecimal amount;

    // Getters and Setters
}
