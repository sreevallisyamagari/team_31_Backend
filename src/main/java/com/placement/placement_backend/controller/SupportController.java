package com.placement.placement_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.placement.placement_backend.entity.SupportMessage;
import com.placement.placement_backend.service.SupportService;

@RestController
@RequestMapping("/api/support")
@CrossOrigin("*")
public class SupportController {

    @Autowired
    private SupportService supportService;

    // Student submits a support ticket
    @PostMapping
    public SupportMessage submitTicket(@RequestBody SupportMessage ticket) {
        return supportService.submitTicket(ticket);
    }

    // Admin views all support tickets
    @GetMapping
    public List<SupportMessage> getAllTickets() {
        return supportService.getAllTickets();
    }

    // Student views only their own tickets
    @GetMapping("/student/{studentId}")
    public List<SupportMessage> getStudentTickets(@PathVariable Long studentId) {
        return supportService.getStudentTickets(studentId);
    }

    // Admin marks a ticket as resolved
    @PutMapping("/{id}")
    public SupportMessage markAsResolved(@PathVariable Long id) {
        return supportService.markAsResolved(id);
    }

}