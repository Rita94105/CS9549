package com.example.history_service.repository;

import com.example.history_service.model.History;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends MongoRepository <History, String> {
    // find all
}
