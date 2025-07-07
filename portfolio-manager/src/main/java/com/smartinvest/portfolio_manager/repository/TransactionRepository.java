package com.smartinvest.portfolio_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartinvest.portfolio_manager.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
