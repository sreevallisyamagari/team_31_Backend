package com.placement.placement_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placement.placement_backend.entity.Application;
import com.placement.placement_backend.entity.CompanyDrive;
import com.placement.placement_backend.entity.User;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByStudent(User student);

    List<Application> findByDrive(CompanyDrive drive);

    List<Application> findByStatus(String status);

    // Prevent Duplicate Applications
    Optional<Application> findByStudentAndDrive(User student, CompanyDrive drive);

}