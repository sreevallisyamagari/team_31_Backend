package com.placement.placement_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.placement_backend.entity.Application;
import com.placement.placement_backend.repository.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository repository;

    // Student Apply
    public Application apply(Application application) {

        application.setStatus("Applied");

        return repository.save(application);
    }

    // View All Applications
    public List<Application> getAllApplications() {
        return repository.findAll();
    }

    // Student Applications
    public List<Application> getStudentApplications(Long studentId) {
        return repository.findByStudentId(studentId);
    }

    // Drive Applications
    public List<Application> getDriveApplications(Long driveId) {
        return repository.findByDriveId(driveId);
    }

    // Update Status
    public Application updateStatus(Long id, String status) {

        Application application = repository.findById(id).orElse(null);

        if (application == null) {
            return null;
        }

        application.setStatus(status);

        return repository.save(application);
    }

    // Applications By Status
    public List<Application> getApplicationsByStatus(String status) {

        return repository.findByStatus(status);

    }
}