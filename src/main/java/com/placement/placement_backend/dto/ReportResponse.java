package com.placement.placement_backend.dto;

public class ReportResponse {

    private long totalStudents;
    private long totalDrives;
    private long totalApplications;
    private long applied;
    private long shortlisted;
    private long selected;
    private long rejected;

    public ReportResponse() {
    }

    public ReportResponse(long totalStudents,
            long totalDrives,
            long totalApplications,
            long applied,
            long shortlisted,
            long selected,
            long rejected) {
        this.totalStudents = totalStudents;
        this.totalDrives = totalDrives;
        this.totalApplications = totalApplications;
        this.applied = applied;
        this.shortlisted = shortlisted;
        this.selected = selected;
        this.rejected = rejected;
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

    public long getApplied() {
        return applied;
    }

    public void setApplied(long applied) {
        this.applied = applied;
    }

    public long getShortlisted() {
        return shortlisted;
    }

    public void setShortlisted(long shortlisted) {
        this.shortlisted = shortlisted;
    }

    public long getSelected() {
        return selected;
    }

    public void setSelected(long selected) {
        this.selected = selected;
    }

    public long getRejected() {
        return rejected;
    }

    public void setRejected(long rejected) {
        this.rejected = rejected;
    }
}