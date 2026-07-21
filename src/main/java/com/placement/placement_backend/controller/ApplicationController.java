package com.placement.placement_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.placement.placement_backend.dto.ApplyRequest;
import com.placement.placement_backend.entity.Application;
import com.placement.placement_backend.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin("*")
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    // Student Apply
    @PostMapping
    public Application apply(@RequestBody ApplyRequest request) {

        return service.apply(request);

    }

    // View All Applications
    @GetMapping
    public List<Application> getAllApplications() {

        return service.getAllApplications();

    }

    // Student Applications
    @GetMapping("/student/{studentId}")
    public List<Application> getStudentApplications(
            @PathVariable Long studentId) {

        return service.getStudentApplications(studentId);

    }

    // Drive Applications
    @GetMapping("/drive/{driveId}")
    public List<Application> getDriveApplications(
            @PathVariable Long driveId) {

        return service.getDriveApplications(driveId);

    }

    // Applications By Status
    @GetMapping("/status/{status}")
    public List<Application> getApplicationsByStatus(
            @PathVariable String status) {

        return service.getApplicationsByStatus(status);

    }

    // Update Status
    @PutMapping("/{id}")
    public Application updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return service.updateStatus(id, status);

    }

    // Bulk Update Status
    @PutMapping("/bulk-status")
    public String bulkUpdateStatus(
            @RequestBody List<Long> ids,
            @RequestParam String status) {

        service.bulkUpdateStatus(ids, status);
        return "Bulk Update Successful";
    }

}