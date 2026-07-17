package com.placement.placement_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.placement_backend.entity.SupportMessage;
import com.placement.placement_backend.repository.SupportRepository;

@Service
public class SupportService {

    @Autowired
    private SupportRepository supportRepository;

    // Student submits a ticket
    public SupportMessage submitTicket(SupportMessage ticket) {

        ticket.setStatus("Pending");

        return supportRepository.save(ticket);
    }

    // Admin views all tickets
    public List<SupportMessage> getAllTickets() {

        return supportRepository.findAll();
    }

    // Student views only their tickets
    public List<SupportMessage> getStudentTickets(Long studentId) {

        return supportRepository.findTicketsByStudentId(studentId);
    }

    // Admin marks a ticket as resolved
    public SupportMessage markAsResolved(Long id) {

        SupportMessage ticket = supportRepository.findById(id).orElse(null);

        if (ticket == null) {
            return null;
        }

        ticket.setStatus("Resolved");

        return supportRepository.save(ticket);
    }

    // Pending Tickets Count
    public long getPendingCount() {

        return supportRepository.countByStatus("Pending");

    }

}