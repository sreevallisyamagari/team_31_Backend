package com.placement.placement_backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.placement.placement_backend.dto.NotificationResponse;
import com.placement.placement_backend.dto.ProfileResponse;
import com.placement.placement_backend.entity.Application;
import com.placement.placement_backend.entity.CompanyDrive;
import com.placement.placement_backend.service.ApplicationService;
import com.placement.placement_backend.service.CompanyDriveService;
import com.placement.placement_backend.service.UserService;

@RestController
@RequestMapping("/api/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyDriveService companyDriveService;

    @Autowired
    private ApplicationService applicationService;

    // Student Profile
    @GetMapping("/profile/{id}")
    public ProfileResponse getProfile(@PathVariable Long id) {
        return userService.getProfile(id);
    }

    // View Company Drives
    @GetMapping("/drives")
    public List<CompanyDrive> getAllDrives() {
        return companyDriveService.getAllDrives();
    }

    // My Applications
    @GetMapping("/applications/{studentId}")
    public List<Application> getMyApplications(@PathVariable Long studentId) {
        return applicationService.getStudentApplications(studentId);
    }

    // Placement Results
    @GetMapping("/results/{studentId}")
    public List<Application> getPlacementResults(@PathVariable Long studentId) {

        return applicationService.getStudentApplications(studentId);

    }

    // Update Student Profile
    @PutMapping("/profile/{id}")
    public ProfileResponse updateProfile(@PathVariable Long id,
            @RequestBody ProfileResponse profile) {
        return userService.updateProfile(id, profile);
    }

    // Notifications
    @GetMapping("/notifications/{studentId}")
    public List<NotificationResponse> getNotifications(@PathVariable Long studentId) {

        List<NotificationResponse> notifications = new ArrayList<>();

        List<Application> applications = applicationService.getStudentApplications(studentId);

        for (Application app : applications) {

            if ("Applied".equalsIgnoreCase(app.getStatus())) {
                notifications.add(new NotificationResponse(
                        "Application Submitted",
                        "Your application has been submitted successfully."));
            }

            if ("Shortlisted".equalsIgnoreCase(app.getStatus())) {
                notifications.add(new NotificationResponse(
                        "Congratulations!",
                        "You have been shortlisted for the company drive."));
            }

            if ("Selected".equalsIgnoreCase(app.getStatus())) {
                notifications.add(new NotificationResponse(
                        "Selected",
                        "Congratulations! You have been selected."));
            }

            if ("Rejected".equalsIgnoreCase(app.getStatus())) {
                notifications.add(new NotificationResponse(
                        "Application Update",
                        "Unfortunately, you were not selected."));
            }
        }

        return notifications;
    }
}