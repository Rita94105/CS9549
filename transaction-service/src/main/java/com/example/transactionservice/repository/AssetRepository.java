// src/main/java/com/example/transactionservice/repository/AssetRepository.java
package com.example.transactionservice.repository;

import com.example.transactionservice.model.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssetRepository extends MongoRepository<Asset, String> {
    Asset findByUsernameAndCurrencyCode(String username, String currencyCode);
}
