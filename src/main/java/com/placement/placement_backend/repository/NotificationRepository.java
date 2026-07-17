package com.placement.placement_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.placement_backend.entity.Notification;
import com.placement.placement_backend.entity.User;

public interface NotificationRepository
        extends JpaRepository<Notification, Long> {

    List<Notification> findByStudentOrderByCreatedAtDesc(User student);

    long countByStudentAndIsReadFalse(User student);

}