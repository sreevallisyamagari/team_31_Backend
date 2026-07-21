package com.placement.placement_backend.dto;

public class ProfileResponse {

    private Long id;
    private String name;
    private String email;
    private String department;
    private Double cgpa;
    private Integer backlogs;
    private String phone;
    private String resume;
    private String profilePictureUrl;

    public ProfileResponse() {
    }

    public ProfileResponse(Long id, String name, String email,
            String department, Double cgpa,
            Integer backlogs, String phone,
            String resume, String profilePictureUrl) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.cgpa = cgpa;
        this.backlogs = backlogs;
        this.phone = phone;
        this.resume = resume;
        this.profilePictureUrl = profilePictureUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getBacklogs() {
        return backlogs;
    }

    public void setBacklogs(Integer backlogs) {
        this.backlogs = backlogs;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
}