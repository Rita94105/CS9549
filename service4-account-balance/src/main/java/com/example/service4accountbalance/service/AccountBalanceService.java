package com.example.service4accountbalance.service;


import com.example.service4accountbalance.client.UserClient;
import com.example.service4accountbalance.dto.User;
import com.example.service4accountbalance.model.AccountBalance;
import com.example.service4accountbalance.repository.AccountBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountBalanceService {

    @Autowired
    private AccountBalanceRepository repository;

    @Autowired
    private UserClient userClient;

    public AccountBalance createOrUpdateBalance(AccountBalance balance) {
        return repository.save(balance);
    }

    public List<AccountBalance> getBalancesByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public void deleteBalance(String id) {
        repository.deleteById(id);
    }

    public User getUserDetails(String userId) {
        return userClient.getUserById(userId);
    }
}