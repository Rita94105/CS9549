package com.example.history_service.controller;
import com.example.history_service.model.History;
import com.example.history_service.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping
    public List<History> getAllHistory() {
        return historyService.getAllHistory();
    }
}
