package com.placement.placement_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.placement.placement_backend.entity.CompanyDrive;
import com.placement.placement_backend.service.CompanyDriveService;

@RestController
@RequestMapping("/api/drives")
@CrossOrigin("*")
public class CompanyDriveController {

    @Autowired
    private CompanyDriveService service;

    // Add Drive
    @PostMapping
    public CompanyDrive addDrive(@RequestBody CompanyDrive drive) {
        return service.addDrive(drive);
    }

    // View All Drives
    @GetMapping
    public List<CompanyDrive> getAllDrives() {
        return service.getAllDrives();
    }

    // View Drive By Id
    @GetMapping("/{id}")
    public CompanyDrive getDriveById(@PathVariable Long id) {
        return service.getDriveById(id);
    }

    // Update Drive
    @PutMapping("/{id}")
    public CompanyDrive updateDrive(@PathVariable Long id,
                                    @RequestBody CompanyDrive drive) {

        return service.updateDrive(id, drive);
    }

    // Delete Drive
    @DeleteMapping("/{id}")
    public String deleteDrive(@PathVariable Long id) {

        return service.deleteDrive(id);
    }

}