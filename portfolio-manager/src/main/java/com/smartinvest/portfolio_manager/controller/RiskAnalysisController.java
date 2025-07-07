package com.smartinvest.portfolio_manager.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartinvest.portfolio_manager.service.RiskAnalysisService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/risk")
@RequiredArgsConstructor
public class RiskAnalysisController {

    private final RiskAnalysisService riskService;

    @GetMapping("/{portfolioId}")
    public ResponseEntity<?> analyze(@PathVariable Long portfolioId) {
        double score = riskService.calculateRiskScore(portfolioId);
        String level = riskService.getRiskLevel(score);

        Map<String, Object> result = Map.of(
                "portfolioId", portfolioId,
                "riskScore", score,
                "riskLevel", level
        );

        return ResponseEntity.ok(result);
    }
}
