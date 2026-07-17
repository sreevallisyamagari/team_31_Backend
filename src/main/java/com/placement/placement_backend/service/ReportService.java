package com.placement.placement_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.placement_backend.dto.ReportResponse;
import com.placement.placement_backend.repository.ApplicationRepository;
import com.placement.placement_backend.repository.CompanyDriveRepository;
import com.placement.placement_backend.repository.UserRepository;

@Service
public class ReportService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyDriveRepository driveRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    public ReportResponse getReport() {

        return new ReportResponse(

                userRepository.count(),

                driveRepository.count(),

                applicationRepository.count(),

                applicationRepository.findByStatus("Applied").size(),

                applicationRepository.findByStatus("Shortlisted").size(),

                applicationRepository.findByStatus("Selected").size(),

                applicationRepository.findByStatus("Rejected").size()

        );

    }

}