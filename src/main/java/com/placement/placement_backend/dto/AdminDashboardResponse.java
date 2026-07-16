package com.placement.placement_backend.dto;

public class AdminDashboardResponse {

    private long totalStudents;
    private long totalDrives;
    private long totalApplications;

    public AdminDashboardResponse() {
    }

    public AdminDashboardResponse(long totalStudents, long totalDrives, long totalApplications) {
        this.totalStudents = totalStudents;
        this.totalDrives = totalDrives;
        this.totalApplications = totalApplications;
    }

    public long getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(long totalStudents) {
        this.totalStudents = totalStudents;
    }

    public long getTotalDrives() {
        return totalDrives;
    }

    public void setTotalDrives(long totalDrives) {
        this.totalDrives = totalDrives;
    }

    public long getTotalApplications() {
        return totalApplications;
    }

    public void setTotalApplications(long totalApplications) {
        this.totalApplications = totalApplications;
    }
}