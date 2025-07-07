package com.smartinvest.portfolio_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartinvest.portfolio_manager.entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findByUserUsername(String username);
}


