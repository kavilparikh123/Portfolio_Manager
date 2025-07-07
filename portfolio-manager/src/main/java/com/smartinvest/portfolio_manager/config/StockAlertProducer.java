package com.smartinvest.portfolio_manager.config;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StockAlertProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendAlert(String message) {
        kafkaTemplate.send("stock-alerts", message);
    }
}
