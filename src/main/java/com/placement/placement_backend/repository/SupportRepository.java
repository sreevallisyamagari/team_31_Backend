package com.placement.placement_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.placement.placement_backend.entity.SupportMessage;

@Repository
public interface SupportRepository extends JpaRepository<SupportMessage, Long> {

    @Query("SELECT s FROM SupportMessage s WHERE s.studentId = :studentId")
    List<SupportMessage> findTicketsByStudentId(@Param("studentId") Long studentId);

    // Count Pending Tickets
    long countByStatus(String status);

}