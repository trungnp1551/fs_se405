package com.mobile.dashboard.services;

import com.mobile.dashboard.repositories.ReportRepository;
import com.mobile.dashboard.models.Report;
import com.mobile.dashboard.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public void proceedReport(String id) {
        Report report = reportRepository.findById(id).orElse(null);
        if (report != null) {
            report.setProceeded(true);
            reportRepository.save(report);
        }

    }

}
