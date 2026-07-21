package com.placement.placement_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.placement_backend.dto.AdminDashboardResponse;
import com.placement.placement_backend.dto.StudentResponse;
import com.placement.placement_backend.entity.CompanyDrive;
import com.placement.placement_backend.entity.Role;
import com.placement.placement_backend.entity.User;
import com.placement.placement_backend.repository.ApplicationRepository;
import com.placement.placement_backend.repository.CompanyDriveRepository;
import com.placement.placement_backend.repository.UserRepository;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyDriveRepository companyDriveRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    // Dashboard
    public AdminDashboardResponse getDashboard() {

        return new AdminDashboardResponse(
                userRepository.count(),
                companyDriveRepository.count(),
                applicationRepository.count()
        );
    }

    // View All Students
    public List<StudentResponse> getAllStudents() {

        List<User> students = userRepository.findByRole(Role.STUDENT);

        return students.stream().map(user -> new StudentResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getDepartment(),
                user.getCgpa(),
                user.getBacklogs(),
                user.getPhone(),
                user.getResume(),
                user.getRole().name()
        )).collect(Collectors.toList());
    }

    // Eligible Students
    public List<StudentResponse> getEligibleStudents(Long driveId) {

        CompanyDrive drive = companyDriveRepository.findById(driveId).orElse(null);

        if (drive == null) {
            return List.of();
        }

        List<User> students = userRepository.findByRole(Role.STUDENT);

        return students.stream()

                .filter(student ->
                        student.getDepartment().equalsIgnoreCase(drive.getDepartment())
                                && student.getCgpa() >= drive.getMinCgpa()
                                && student.getBacklogs() <= drive.getMaxBacklogs())

                .map(student -> new StudentResponse(
                        student.getId(),
                        student.getName(),
                        student.getEmail(),
                        student.getDepartment(),
                        student.getCgpa(),
                        student.getBacklogs(),
                        student.getPhone(),
                        student.getResume(),
                        student.getRole().name()))

                .collect(Collectors.toList());
    }

    // Get Student By Id
    public User getStudentById(Long id) {

        return userRepository.findById(id).orElse(null);

    }

    // Update Student
    public User updateStudent(Long id, User updatedUser) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        user.setName(updatedUser.getName());
        user.setDepartment(updatedUser.getDepartment());
        user.setCgpa(updatedUser.getCgpa());
        user.setBacklogs(updatedUser.getBacklogs());
        user.setPhone(updatedUser.getPhone());

        return userRepository.save(user);
    }

    // Delete Student
    public String deleteStudent(Long id) {

        userRepository.deleteById(id);

        return "Student Deleted Successfully";
    }
    public User createAdmin(User admin) {

    // Check if email already exists
    if (userRepository.findByEmail(admin.getEmail()).isPresent()) {
        throw new RuntimeException("Email already exists");
    }

    // Set the role to ADMIN
    admin.setRole(Role.ADMIN);

    // Save the new admin
    return userRepository.save(admin);
}
// Get All Admins
public List<User> getAllAdmins() {
    return userRepository.findByRole(Role.ADMIN);
}
// Update Admin
public User updateAdmin(Long id, User updatedAdmin) {

    User admin = userRepository.findById(id).orElse(null);

    if (admin == null) {
        return null;
    }

    admin.setName(updatedAdmin.getName());
    admin.setEmail(updatedAdmin.getEmail());
    admin.setPhone(updatedAdmin.getPhone());

    return userRepository.save(admin);
}
// Delete Admin
public String deleteAdmin(Long id) {

    userRepository.deleteById(id);

    return "Admin Deleted Successfully";
}
    

}