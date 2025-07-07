package com.smartinvest.portfolio_manager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartinvest.portfolio_manager.service.PortfolioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/portfolios")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping
    public ResponseEntity<?> createPortfolio(@RequestParam String name,
                                             @AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(portfolioService.createPortfolio(user.getUsername(), name));
    }

    @GetMapping
    public ResponseEntity<?> getPortfolios(@AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(portfolioService.getUserPortfolios(user.getUsername()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPortfolio(@PathVariable Long id) {
        return portfolioService.getPortfolio(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
