package com.placement.placement_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.placement_backend.dto.ApplyRequest;
import com.placement.placement_backend.entity.Application;
import com.placement.placement_backend.entity.CompanyDrive;
import com.placement.placement_backend.entity.User;
import com.placement.placement_backend.repository.ApplicationRepository;
import com.placement.placement_backend.repository.CompanyDriveRepository;
import com.placement.placement_backend.repository.UserRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyDriveRepository companyDriveRepository;

    @Autowired
    private NotificationService notificationService;

    // Student Apply
    public Application apply(ApplyRequest request) {

        User student = userRepository.findById(request.getStudentId()).orElse(null);

        CompanyDrive drive = companyDriveRepository.findById(request.getDriveId()).orElse(null);

        if (student == null || drive == null) {
            return null;
        }

        // Prevent Duplicate Application
        if (applicationRepository.findByStudentAndDrive(student, drive).isPresent()) {
            throw new RuntimeException("You have already applied for this company drive.");
        }

        Application application = new Application();

        application.setStudent(student);
        application.setDrive(drive);
        application.setStatus("Applied");
        application.setAppliedDate(java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd MMM yyyy")));

        Application savedApplication = applicationRepository.save(application);

        // Create Notification
        notificationService.saveNotification(
                student.getId(),
                "Application Submitted",
                "You have successfully applied for "
                        + drive.getCompanyName()
                        + " - "
                        + drive.getJobRole(),
                "Application"
        );

        return savedApplication;
    }

    // View All Applications
    public List<Application> getAllApplications() {

        return applicationRepository.findAll();

    }

    // Student Applications
    public List<Application> getStudentApplications(Long studentId) {

        User student = userRepository.findById(studentId).orElse(null);

        if (student == null) {
            return List.of();
        }

        return applicationRepository.findByStudent(student);

    }

    // Drive Applications
    public List<Application> getDriveApplications(Long driveId) {

        CompanyDrive drive = companyDriveRepository.findById(driveId).orElse(null);

        if (drive == null) {
            return List.of();
        }

        return applicationRepository.findByDrive(drive);

    }

    // Applications By Status
    public List<Application> getApplicationsByStatus(String status) {

        return applicationRepository.findByStatus(status);

    }

    // Update Status
    public Application updateStatus(Long id, String status) {

        Application application = applicationRepository.findById(id).orElse(null);

        if (application == null) {
            return null;
        }

        application.setStatus(status);

        Application updatedApplication = applicationRepository.save(application);

        String title = "";
        String message = "";

        switch (status.toLowerCase()) {

            case "shortlisted":

                title = "Shortlisted";

                message = "Congratulations! You have been shortlisted for "
                        + application.getDrive().getCompanyName();

                break;

            case "selected":

                title = "Selected";

                message = "Congratulations! You have been selected by "
                        + application.getDrive().getCompanyName();

                break;

            case "rejected":

                title = "Application Rejected";

                message = "Your application for "
                        + application.getDrive().getCompanyName()
                        + " was not selected.";

                break;

            default:

                title = "Application Updated";

                message = "Your application status has been updated to "
                        + status;
        }

        notificationService.saveNotification(
                application.getStudent().getId(),
                title,
                message,
                "Application"
        );

        return updatedApplication;

    }

    // Bulk Update Status
    public void bulkUpdateStatus(List<Long> ids, String status) {
        for (Long id : ids) {
            updateStatus(id, status);
        }
    }
}