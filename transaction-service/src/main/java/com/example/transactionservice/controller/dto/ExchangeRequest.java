// src/main/java/com/example/transactionservice/controller/dto/ExchangeRequest.java
package com.example.transactionservice.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ExchangeRequest {
    @NotBlank
    private String fromCurrency;

    @NotBlank
    private String toCurrency;

    @NotNull
    @Positive
    private BigDecimal amount;

    // Getters and Setters
}
