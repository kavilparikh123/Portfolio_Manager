package com.smartinvest.portfolio_manager.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.smartinvest.portfolio_manager.config.StockApiClient;
import com.smartinvest.portfolio_manager.entity.StockPrice;
import com.smartinvest.portfolio_manager.repository.StockPriceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockPriceService {

    private final StockApiClient stockApiClient;
    private final StockPriceRepository stockRepo;

    public StockPrice updatePrice(String symbol) {
        Double price = stockApiClient.fetchPrice(symbol);
        StockPrice stock = StockPrice.builder()
                .symbol(symbol.toUpperCase())
                .price(price)
                .lastUpdated(LocalDateTime.now())
                .build();
        return stockRepo.save(stock);
    }

    public List<StockPrice> getAll() {
        return stockRepo.findAll();
    }

    public Optional<StockPrice> get(String symbol) {
        return stockRepo.findById(symbol.toUpperCase());
    }
}
