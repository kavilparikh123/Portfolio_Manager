package com.smartinvest.portfolio_manager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartinvest.portfolio_manager.service.StockPriceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockPriceController {

    private final StockPriceService stockService;

    @PostMapping("/update/{symbol}")
    public ResponseEntity<?> update(@PathVariable String symbol) {
        return ResponseEntity.ok(stockService.updatePrice(symbol));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(stockService.getAll());
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<?> get(@PathVariable String symbol) {
        return stockService.get(symbol)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
