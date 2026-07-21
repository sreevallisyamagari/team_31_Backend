package com.placement.placement_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.placement_backend.entity.CompanyDrive;
import com.placement.placement_backend.repository.CompanyDriveRepository;

@Service
public class CompanyDriveService {

    @Autowired
    private CompanyDriveRepository repository;

    // Add Drive
    public CompanyDrive addDrive(CompanyDrive drive) {
        return repository.save(drive);
    }

    // Get All Drives
    public List<CompanyDrive> getAllDrives() {
        return repository.findAll();
    }

    // Get Drive By Id
    public CompanyDrive getDriveById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update Drive
    public CompanyDrive updateDrive(Long id, CompanyDrive drive) {

        CompanyDrive existingDrive = repository.findById(id).orElse(null);

        if (existingDrive != null) {

            existingDrive.setCompanyName(drive.getCompanyName());
            existingDrive.setJobRole(drive.getJobRole());
            existingDrive.setPackageOffered(drive.getPackageOffered());
            existingDrive.setMinCgpa(drive.getMinCgpa());
            existingDrive.setDepartment(drive.getDepartment());
            existingDrive.setMaxBacklogs(drive.getMaxBacklogs());
            existingDrive.setDriveDate(drive.getDriveDate());
            existingDrive.setLocation(drive.getLocation());
            existingDrive.setLogoUrl(drive.getLogoUrl());
            existingDrive.setEmploymentType(drive.getEmploymentType());
            existingDrive.setJobDescription(drive.getJobDescription());

            return repository.save(existingDrive);
        }

        return null;
    }

    // Delete Drive
    public String deleteDrive(Long id) {

        repository.deleteById(id);

        return "Company Drive Deleted Successfully";
    }

}