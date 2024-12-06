// src/main/java/com/example/transactionservice/repository/TransactionRepository.java
package com.example.transactionservice.repository;

import com.example.transactionservice.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    // Additional query methods if needed
}
