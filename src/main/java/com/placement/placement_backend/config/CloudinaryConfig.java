package com.placement.placement_backend.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "fgr1wdui");
        config.put("api_key", "494347484176549");
        config.put("api_secret", "3DXxBdAZbsX2qOjXpNBFlmlArRM");
        return new Cloudinary(config);
    }
}
