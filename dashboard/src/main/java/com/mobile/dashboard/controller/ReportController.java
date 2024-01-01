package com.mobile.dashboard.controller;

import com.mobile.dashboard.models.Report;
import com.mobile.dashboard.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/admin/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

//    @GetMapping
//    public String showSortedReport(Model model) {
//        List<Report> reports = reportService.getAllReports();
//        model.addAttribute("reports", reports);
//        return "reports";
//    }

    @GetMapping()
    public String showReport(Model model) {
        List<Report> reports = reportService.getAllReports();
        reports.sort(Comparator.comparing(Report::getProceeded));
        model.addAttribute("reports", reports);
        return "reports";
    }

    @GetMapping("/proceed/{id}")
    public String proceedReport(@PathVariable String id) {
        reportService.proceedReport(id);
        return "reports";
    }
}
