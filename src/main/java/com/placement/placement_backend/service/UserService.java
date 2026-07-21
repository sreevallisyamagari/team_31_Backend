package com.placement.placement_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.placement.placement_backend.dto.LoginRequest;
import com.placement.placement_backend.dto.LoginResponse;
import com.placement.placement_backend.dto.ProfileResponse;
import com.placement.placement_backend.dto.RegisterRequest;
import com.placement.placement_backend.entity.Role;
import com.placement.placement_backend.entity.User;
import com.placement.placement_backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Register Student
    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setDepartment(request.getDepartment());
        user.setCgpa(request.getCgpa());
        user.setBacklogs(request.getBacklogs());
        user.setPhone(request.getPhone());

        // Every registered user is a STUDENT
        user.setRole(Role.STUDENT);

        userRepository.save(user);

        return "Student Registered Successfully";
    }

    // Login
    public LoginResponse login(LoginRequest request) {

        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

        if (optionalUser.isEmpty()) {
            return new LoginResponse(
                    "Invalid Email",
                    null,
                    "",
                    ""
            );
        }

        User user = optionalUser.get();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new LoginResponse(
                    "Invalid Email or Password",
                    null,
                    "",
                    ""
            );
        }

        return new LoginResponse(
                "Login Successful",
                user.getId(),
                user.getRole().name(),
                user.getName()
        );
    }

    // Get Student Profile
    public ProfileResponse getProfile(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        return new ProfileResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getDepartment(),
                user.getCgpa(),
                user.getBacklogs(),
                user.getPhone(),
                user.getResume(),
                user.getProfilePictureUrl()
        );
    }

    // Update Student Profile
    public ProfileResponse updateProfile(Long id, ProfileResponse profile) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        user.setName(profile.getName());
        user.setEmail(profile.getEmail());
        user.setDepartment(profile.getDepartment());
        user.setCgpa(profile.getCgpa());
        user.setBacklogs(profile.getBacklogs());
        user.setPhone(profile.getPhone());
        
        // Ensure profile picture is updated if provided
        if (profile.getProfilePictureUrl() != null) {
             user.setProfilePictureUrl(profile.getProfilePictureUrl());
        }
        
        // Ensure resume is updated if provided
        if (profile.getResume() != null) {
             user.setResume(profile.getResume());
        }

        userRepository.save(user);

        return new ProfileResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getDepartment(),
                user.getCgpa(),
                user.getBacklogs(),
                user.getPhone(),
                user.getResume(),
                user.getProfilePictureUrl()
        );
    }
}