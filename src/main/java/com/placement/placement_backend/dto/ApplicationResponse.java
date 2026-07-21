package com.placement.placement_backend.dto;

public class ApplicationResponse {

    private Long applicationId;
    private Long studentId;
    private String studentName;
    private String companyName;
    private String jobRole;
    private String status;
    private String resume;

    public ApplicationResponse() {
    }

    public ApplicationResponse(Long applicationId,
            Long studentId,
            String studentName,
            String companyName,
            String jobRole,
            String status,
            String resume) {
        this.applicationId = applicationId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.companyName = companyName;
        this.jobRole = jobRole;
        this.status = status;
        this.resume = resume;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}