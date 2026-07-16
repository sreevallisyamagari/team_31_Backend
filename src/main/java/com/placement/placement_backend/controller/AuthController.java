package com.placement.placement_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.placement.placement_backend.dto.LoginRequest;
import com.placement.placement_backend.dto.LoginResponse;
import com.placement.placement_backend.dto.ProfileResponse;
import com.placement.placement_backend.dto.RegisterRequest;
import com.placement.placement_backend.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserService userService;

    // Register Student
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    // Login User
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    // Get Student Profile
    @GetMapping("/profile/{id}")
    public ProfileResponse getProfile(@PathVariable Long id) {
        return userService.getProfile(id);
    }
}