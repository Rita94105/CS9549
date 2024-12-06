// src/main/java/com/example/transactionservice/service/TransactionService.java
package com.example.transactionservice.service;

import com.example.transactionservice.exception.InsufficientFundsException;
import com.example.transactionservice.exception.UnsupportedCurrencyException;
import com.example.transactionservice.model.Asset;
import com.example.transactionservice.model.Transaction;
import com.example.transactionservice.repository.AssetRepository;
import com.example.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Service
public class TransactionService {
    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private static final Set<String> SUPPORTED_CURRENCIES = Set.of("USD", "EUR", "GBP", "JPY");

    public Transaction exchangeCurrency(String username, String fromCurrency, String toCurrency, BigDecimal amount) {
        // QR1: Check if currencies are supported
        if (!SUPPORTED_CURRENCIES.contains(fromCurrency) || !SUPPORTED_CURRENCIES.contains(toCurrency)) {
            throw new UnsupportedCurrencyException("Unsupported currency.");
        }

        // Fetch user's assets
        Asset fromAsset = assetRepository.findByUsernameAndCurrencyCode(username, fromCurrency);
        Asset toAsset = assetRepository.findByUsernameAndCurrencyCode(username, toCurrency);

        if (fromAsset == null || toAsset == null) {
            throw new InsufficientFundsException("Asset not found.");
        }

        // Check if user has enough assets
        if (fromAsset.getAmount().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Not enough assets.");
        }

        // Perform exchange (simplified without real exchange rates)
        fromAsset.setAmount(fromAsset.getAmount().subtract(amount));
        toAsset.setAmount(toAsset.getAmount().add(amount));

        assetRepository.save(fromAsset);
        assetRepository.save(toAsset);

        // FR3: Generate transaction record
        Transaction transaction = new Transaction();
        transaction.setType("EXCHANGE");
        transaction.setFromCurrency(fromCurrency);
        transaction.setToCurrency(toCurrency);
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setUsername(username);

        return transactionRepository.save(transaction);
    }

    public Transaction purchaseCurrency(String username, String currencyCode, BigDecimal amount) {
        // QR1: Check if currency is supported
        if (!SUPPORTED_CURRENCIES.contains(currencyCode)) {
            throw new UnsupportedCurrencyException("Unsupported currency.");
        }

        // Fetch or create user's asset
        Asset asset = assetRepository.findByUsernameAndCurrencyCode(username, currencyCode);
        if (asset == null) {
            asset = new Asset();
            asset.setCurrencyCode(currencyCode);
            asset.setAmount(BigDecimal.ZERO);
            asset.setUsername(username);
        }

        // Add purchased amount
        asset.setAmount(asset.getAmount().add(amount));
        assetRepository.save(asset);

        // FR3: Generate transaction record
        Transaction transaction = new Transaction();
        transaction.setType("PURCHASE");
        transaction.setFromCurrency(null);
        transaction.setToCurrency(currencyCode);
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setUsername(username);

        return transactionRepository.save(transaction);
    }
}
