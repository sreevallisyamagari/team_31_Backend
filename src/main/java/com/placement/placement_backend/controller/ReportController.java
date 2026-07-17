package com.placement.placement_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.placement.placement_backend.dto.ReportResponse;
import com.placement.placement_backend.service.ReportService;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin("*")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public ReportResponse getReport() {

        return reportService.getReport();

    }

}