package com.smartinvest.portfolio_manager.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StockAlertConsumer {

    private final SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "stock-alerts", groupId = "stock-alert-group")
    public void consume(String message) {
        messagingTemplate.convertAndSend("/topic/alerts", message);
    }
}
