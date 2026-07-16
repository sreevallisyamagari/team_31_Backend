package com.placement.placement_backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.placement.placement_backend.entity.Role;
import com.placement.placement_backend.entity.User;
import com.placement.placement_backend.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (userRepository.findByEmail("admin@gmail.com").isEmpty()) {

            User admin = new User();

            admin.setName("Administrator");
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(Role.ADMIN);

            admin.setDepartment("Administration");
            admin.setCgpa(0.0);
            admin.setBacklogs(0);
            admin.setPhone("9999999999");

            userRepository.save(admin);

            System.out.println("Default Admin Created");
        }

    }
}