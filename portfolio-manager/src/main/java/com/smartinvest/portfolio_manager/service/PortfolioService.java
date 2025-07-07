package com.smartinvest.portfolio_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smartinvest.portfolio_manager.entity.Portfolio;
import com.smartinvest.portfolio_manager.entity.User;
import com.smartinvest.portfolio_manager.repository.PortfolioRepository;
import com.smartinvest.portfolio_manager.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepo;
    private final UserRepository userRepo;

    public Portfolio createPortfolio(String username, String name) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Portfolio portfolio = Portfolio.builder()
                .name(name)
                .user(user)
                .build();

        return portfolioRepo.save(portfolio);
    }

    public List<Portfolio> getUserPortfolios(String username) {
        return portfolioRepo.findByUserUsername(username);
    }

    public Optional<Portfolio> getPortfolio(Long id) {
        return portfolioRepo.findById(id);
    }
}
