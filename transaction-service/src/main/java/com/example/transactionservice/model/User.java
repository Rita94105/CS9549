// src/main/java/com/example/transactionservice/model/User.java
package com.example.transactionservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class User {
    @Id
    private String username;
    private String password;
    // Other user details

    private List<Asset> assets;

    // Getters and Setters
}
