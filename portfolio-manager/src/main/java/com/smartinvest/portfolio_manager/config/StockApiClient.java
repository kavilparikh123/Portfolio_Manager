package com.smartinvest.portfolio_manager.config;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StockApiClient {

    private static final String API_KEY = "2de12dac04ae4f869979166b40ecc1c2";

    public Double fetchPrice(String symbol) {
        try {
            String url = "https://api.twelvedata.com/price?symbol=" + symbol + "&apikey=" + API_KEY;
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
            return Double.parseDouble((String) response.getBody().get("price"));
        } catch (Exception e) {
            throw new RuntimeException("Error fetching stock price for " + symbol);
        }
    }
}
