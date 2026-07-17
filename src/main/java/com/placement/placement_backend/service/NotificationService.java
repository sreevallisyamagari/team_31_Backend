package com.placement.placement_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.placement_backend.entity.Notification;
import com.placement.placement_backend.entity.User;
import com.placement.placement_backend.repository.NotificationRepository;
import com.placement.placement_backend.repository.UserRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    public Notification saveNotification(
            Long studentId,
            String title,
            String message,
            String type) {

        User student = userRepository.findById(studentId).orElse(null);

        if (student == null) {
            return null;
        }

        Notification notification = new Notification();

        notification.setStudent(student);
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setType(type);
        notification.setRead(false);

        return notificationRepository.save(notification);
    }

    public List<Notification> getStudentNotifications(Long studentId) {

        User student = userRepository.findById(studentId).orElse(null);

        if (student == null) {
            return List.of();
        }

        return notificationRepository.findByStudentOrderByCreatedAtDesc(student);

    }

    public long getUnreadCount(Long studentId) {

        User student = userRepository.findById(studentId).orElse(null);

        if (student == null) {
            return 0;
        }

        return notificationRepository.countByStudentAndIsReadFalse(student);

    }

    public void markAsRead(Long id) {

        Notification notification =
                notificationRepository.findById(id).orElse(null);

        if (notification != null) {

            notification.setRead(true);

            notificationRepository.save(notification);

        }

    }

}