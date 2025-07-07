package com.smartinvest.portfolio_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartinvest.portfolio_manager.entity.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice, String> {
}
