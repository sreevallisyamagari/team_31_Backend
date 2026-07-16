package com.placement.placement_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "company_drives")
public class CompanyDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String jobRole;

    private Double packageOffered;

    private Double minCgpa;

    private String department;

    private Integer maxBacklogs;

    private String driveDate;

    private String location;

    public CompanyDrive() {
    }

    public CompanyDrive(Long id, String companyName, String jobRole,
                        Double packageOffered, Double minCgpa,
                        String department, Integer maxBacklogs,
                        String driveDate, String location) {

        this.id = id;
        this.companyName = companyName;
        this.jobRole = jobRole;
        this.packageOffered = packageOffered;
        this.minCgpa = minCgpa;
        this.department = department;
        this.maxBacklogs = maxBacklogs;
        this.driveDate = driveDate;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public Double getPackageOffered() {
        return packageOffered;
    }

    public void setPackageOffered(Double packageOffered) {
        this.packageOffered = packageOffered;
    }

    public Double getMinCgpa() {
        return minCgpa;
    }

    public void setMinCgpa(Double minCgpa) {
        this.minCgpa = minCgpa;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getMaxBacklogs() {
        return maxBacklogs;
    }

    public void setMaxBacklogs(Integer maxBacklogs) {
        this.maxBacklogs = maxBacklogs;
    }

    public String getDriveDate() {
        return driveDate;
    }

    public void setDriveDate(String driveDate) {
        this.driveDate = driveDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}