package com.smartinvest.portfolio_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartinvest.portfolio_manager.entity.Holding;

public interface HoldingRepository extends JpaRepository<Holding, Long> {
}
