package com.placement.placement_backend.dto;

public class LoginResponse {

    private String message;
    private Long id;
    private String role;
    private String name;

    public LoginResponse() {
    }

    public LoginResponse(String message, Long id, String role, String name) {
        this.message = message;
        this.id = id;
        this.role = role;
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}