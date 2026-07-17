package com.placement.placement_backend.dto;

public class ApplyRequest {

    private Long studentId;
    private Long driveId;

    public ApplyRequest() {
    }

    public ApplyRequest(Long studentId, Long driveId) {
        this.studentId = studentId;
        this.driveId = driveId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getDriveId() {
        return driveId;
    }

    public void setDriveId(Long driveId) {
        this.driveId = driveId;
    }
}