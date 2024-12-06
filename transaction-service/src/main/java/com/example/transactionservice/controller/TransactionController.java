// src/main/java/com/example/transactionservice/controller/TransactionController.java
package com.example.transactionservice.controller;

import com.example.transactionservice.controller.dto.ExchangeRequest;
import com.example.transactionservice.controller.dto.PurchaseRequest;
import com.example.transactionservice.model.Transaction;
import com.example.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    // QR4: Secured endpoints
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/exchange")
    public ResponseEntity<?> exchangeCurrency(@Valid @RequestBody ExchangeRequest request, Principal principal) {
        // QR2: Confirm transaction details with the user before processing
        // For simplicity, we assume confirmation is handled on the client side
        Transaction transaction = transactionService.exchangeCurrency(
                principal.getName(),
                request.getFromCurrency(),
                request.getToCurrency(),
                request.getAmount()
        );
        return ResponseEntity.ok(transaction);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseCurrency(@Valid @RequestBody PurchaseRequest request, Principal principal) {
        // QR2: Confirm transaction details with the user before processing
        Transaction transaction = transactionService.purchaseCurrency(
                principal.getName(),
                request.getCurrencyCode(),
                request.getAmount()
        );
        return ResponseEntity.ok(transaction);
    }
}
