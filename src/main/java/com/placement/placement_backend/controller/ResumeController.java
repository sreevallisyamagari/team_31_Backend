package com.placement.placement_backend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.placement.placement_backend.entity.User;
import com.placement.placement_backend.repository.UserRepository;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin("*")
public class ResumeController {

    @Autowired
    private UserRepository userRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    // Upload Resume
    @PostMapping("/upload/{studentId}")
    public String uploadResume(
            @PathVariable Long studentId,
            @RequestParam("file") MultipartFile file) throws IOException {

        User user = userRepository.findById(studentId).orElse(null);

        if (user == null) {
            return "Student Not Found";
        }

        // Create upload folder if it doesn't exist
        File uploadFolder = new File(uploadDir);

        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }

        String fileName = studentId + "_" + file.getOriginalFilename();

        Path path = Paths.get(uploadFolder.getAbsolutePath(), fileName);

        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Resume saved to: " + path.toAbsolutePath());

        // Save only filename in database
        user.setResume(fileName);

        userRepository.save(user);

        return "Resume Uploaded Successfully";
    }

    // View Resume
    @GetMapping("/view/{studentId}")
    public ResponseEntity<Resource> viewResume(@PathVariable Long studentId) throws IOException {

        User user = userRepository.findById(studentId).orElse(null);

        if (user == null || user.getResume() == null) {
            return ResponseEntity.notFound().build();
        }

        Path path = Paths.get(uploadDir, user.getResume());

        Resource resource = new UrlResource(path.toUri());

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

    // Download Resume
    @GetMapping("/download/{studentId}")
    public ResponseEntity<Resource> downloadResume(@PathVariable Long studentId) throws IOException {

        User user = userRepository.findById(studentId).orElse(null);

        if (user == null || user.getResume() == null) {
            return ResponseEntity.notFound().build();
        }

        Path path = Paths.get(uploadDir, user.getResume());

        Resource resource = new UrlResource(path.toUri());

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + user.getResume() + "\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

}