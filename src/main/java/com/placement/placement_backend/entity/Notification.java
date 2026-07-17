package com.placement.placement_backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private User student;

    private String title;

    @Column(length = 500)
    private String message;

    private String type;

    private boolean isRead = false;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Notification() {

    }

    

    public void setId(Long id) {
        this.id = id;
    }



    public void setStudent(User student) {
        this.student = student;
    }



    public void setTitle(String title) {
        this.title = title;
    }



    public void setMessage(String message) {
        this.message = message;
    }



    public void setType(String type) {
        this.type = type;
    }



    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }



    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }



    public Long getId() {
        return id;
    }

    public User getStudent() {
        return student;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public boolean isRead() {
        return isRead;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Generate getters and setters
    
}