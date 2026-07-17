package com.placement.placement_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.placement.placement_backend.entity.Notification;
import com.placement.placement_backend.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{studentId}")
    public List<Notification> getNotifications(
            @PathVariable Long studentId) {

        return notificationService.getStudentNotifications(studentId);

    }

    @GetMapping("/unread/{studentId}")
    public long getUnreadCount(
            @PathVariable Long studentId) {

        return notificationService.getUnreadCount(studentId);

    }

    @PutMapping("/read/{id}")
    public String markAsRead(
            @PathVariable Long id) {

        notificationService.markAsRead(id);

        return "Notification marked as read";

    }

}