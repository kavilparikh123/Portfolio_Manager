package com.smartinvest.portfolio_manager.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockPrice {

    @Id
    private String symbol;

    private Double price;

    private LocalDateTime lastUpdated;
}
