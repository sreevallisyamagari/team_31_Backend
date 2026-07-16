package com.placement.placement_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placement.placement_backend.entity.CompanyDrive;

@Repository
public interface CompanyDriveRepository extends JpaRepository<CompanyDrive, Long> {

}