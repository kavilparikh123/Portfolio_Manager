package com.smartinvest.portfolio_manager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartinvest.portfolio_manager.config.StockAlertProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class StockAlertController {

    private final StockAlertProducer alertProducer;

    @PostMapping
    public ResponseEntity<?> sendAlert(@RequestParam String message) {
        alertProducer.sendAlert(message);
        return ResponseEntity.ok("Alert sent.");
    }
}
