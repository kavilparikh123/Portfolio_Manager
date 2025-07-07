package com.smartinvest.portfolio_manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartinvest.portfolio_manager.entity.Holding;
import com.smartinvest.portfolio_manager.entity.Portfolio;
import com.smartinvest.portfolio_manager.repository.HoldingRepository;
import com.smartinvest.portfolio_manager.repository.PortfolioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RiskAnalysisService {

    private final PortfolioRepository portfolioRepo;
    private final HoldingRepository holdingRepo;

    public Double calculateRiskScore(Long portfolioId) {
        Portfolio portfolio = portfolioRepo.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        List<Holding> holdings = portfolio.getHoldings();
        if (holdings.isEmpty()) return 0.0;

        double score = 0.0;
        for (Holding h : holdings) {
            // Simple logic: more quantity of volatile stock increases risk
            score += h.getQuantity() * Math.random(); // placeholder for real risk model
        }

        return Math.min(score / 1000.0, 1.0); // normalized between 0 and 1
    }

    public String getRiskLevel(double score) {
        if (score < 0.3) return "Low";
        if (score < 0.7) return "Moderate";
        return "High";
    }
}
