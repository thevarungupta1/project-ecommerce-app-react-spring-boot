package com.thevarungupta.grocery_app_api.service;

import com.thevarungupta.grocery_app_api.dto.AuthResponse;
import com.thevarungupta.grocery_app_api.dto.LoginRequest;
import com.thevarungupta.grocery_app_api.dto.RegisterRequest;
import com.thevarungupta.grocery_app_api.dto.UserDto;
import com.thevarungupta.grocery_app_api.entity.AppUser;
import com.thevarungupta.grocery_app_api.repository.AppUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse register(RegisterRequest request) {
        if (appUserRepository.existsByEmail(request.email())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already registered");
        }

        AppUser user = AppUser.builder()
                .firstName(request.firstName())
                .email(request.email())
                .mobile(request.mobile())
                .password(passwordEncoder.encode(request.password()))
                .build();

        AppUser savedUser = appUserRepository.save(user);
        String token = jwtService.generateToken(savedUser.getEmail());

        return new AuthResponse(
                token,
                new UserDto(savedUser.getFirstName(), savedUser.getEmail(), savedUser.getMobile()),
                "Registration successful"
        );
    }

    public AuthResponse login(LoginRequest request) {
        AppUser user = appUserRepository.findByEmail(request.email())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        String token = jwtService.generateToken(user.getEmail());
        return new AuthResponse(
                token,
                new UserDto(user.getFirstName(), user.getEmail(), user.getMobile()),
                "Login successful"
        );
    }
}
