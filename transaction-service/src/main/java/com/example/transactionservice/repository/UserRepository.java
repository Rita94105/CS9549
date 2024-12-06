// src/main/java/com/example/transactionservice/repository/UserRepository.java
package com.example.transactionservice.repository;

import com.example.transactionservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // Additional query methods if needed
}
