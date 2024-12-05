package com.example.service4accountbalance.repository;

import com.example.service4accountbalance.model.AccountBalance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountBalanceRepository extends MongoRepository<AccountBalance, String> {
    List<AccountBalance> findByUserId(String userId);
}
