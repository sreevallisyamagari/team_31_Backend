package com.placement.placement_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.placement.placement_backend.dto.AdminDashboardResponse;
import com.placement.placement_backend.dto.StudentResponse;
import com.placement.placement_backend.entity.User;
import com.placement.placement_backend.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Dashboard
    @GetMapping("/dashboard")
    public AdminDashboardResponse getDashboard() {

        return adminService.getDashboard();

    }

    // View All Students
    @GetMapping("/students")
    public List<StudentResponse> getAllStudents() {

        return adminService.getAllStudents();

    }

    // Eligible Students
    @GetMapping("/eligible/{driveId}")
    public List<StudentResponse> getEligibleStudents(
            @PathVariable Long driveId) {

        return adminService.getEligibleStudents(driveId);

    }

    // Get Student By ID
    @GetMapping("/student/{id}")
    public User getStudent(@PathVariable Long id) {

        return adminService.getStudentById(id);

    }

    // Update Student
    @PutMapping("/student/{id}")
    public User updateStudent(
            @PathVariable Long id,
            @RequestBody User user) {

        return adminService.updateStudent(id, user);

    }

    // Delete Student
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id) {

        return adminService.deleteStudent(id);

    }

}