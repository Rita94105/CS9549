package com.example.service4accountbalance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account_balances")
public class AccountBalance {

    @Id
    private String id;
    private String userId;
    private String currency;
    private double balance;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
