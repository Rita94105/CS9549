package com.example.service4accountbalance.controller;

import com.example.service4accountbalance.dto.User;
import com.example.service4accountbalance.model.AccountBalance;
import com.example.service4accountbalance.service.AccountBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account-balances")
public class AccountBalanceController {

    @Autowired
    private AccountBalanceService service;

    @PostMapping
    public AccountBalance createOrUpdateBalance(@RequestBody AccountBalance balance) {
        return service.createOrUpdateBalance(balance);
    }

    @GetMapping("/{userId}")
    public List<AccountBalance> getBalancesByUserId(@PathVariable String userId) {
        return service.getBalancesByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteBalance(@PathVariable String id) {
        service.deleteBalance(id);
    }

    @GetMapping("/user/{userId}")
    public User getUserDetails(@PathVariable String userId) {
        return service.getUserDetails(userId);
    }
}
