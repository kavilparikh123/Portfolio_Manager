package com.smartinvest.portfolio_manager.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartinvest.portfolio_manager.config.JwtUtil;
import com.smartinvest.portfolio_manager.dto.LoginRequest;
import com.smartinvest.portfolio_manager.dto.RegisterRequest;
import com.smartinvest.portfolio_manager.entity.Role;
import com.smartinvest.portfolio_manager.entity.User;
import com.smartinvest.portfolio_manager.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public void register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.INVESTOR)
                .build();
        userRepo.save(user);
    }

    public String login(LoginRequest request) {
        User user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }
        return jwtUtil.generateToken(user.getUsername());
    }
}
