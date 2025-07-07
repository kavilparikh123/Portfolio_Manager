package com.smartinvest.portfolio_manager;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.smartinvest.portfolio_manager.service.StockPriceService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StockScheduler {

    private final StockPriceService stockService;

    @Scheduled(fixedRate = 300000) // every 5 minute
    public void updateTrackedStocks() {
        List<String> symbols = List.of("AAPL", "GOOGL", "MSFT");
        symbols.forEach(stockService::updatePrice);
    }
}
