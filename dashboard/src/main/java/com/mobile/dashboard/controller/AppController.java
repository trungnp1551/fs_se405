package com.mobile.dashboard.controller;

import com.mobile.dashboard.models.Report;
import com.mobile.dashboard.models.User;
import com.mobile.dashboard.services.ReportService;
import com.mobile.dashboard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.mobile.dashboard.services.ReportService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AppController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private UserService userService;


    @GetMapping("/dashboard")
    public String showTables(Model model) {
        List<User> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            users.sort(Comparator.comparing(User::getBannedDate).reversed());
            List<User> bannedList = new ArrayList<>();
            List<User> top3 = new ArrayList<>();
            bannedList.add(users.get(0));
            model.addAttribute("bannedList", bannedList);
            users.sort(Comparator.comparing(User::getReportNumber).reversed());
            top3.add(users.get(0));
            top3.add(users.get(1));
            top3.add(users.get(2));
            model.addAttribute("top3", top3);
        }

        List<Report> reports = reportService.getAllReports();
        if (!reports.isEmpty()) {
            reports.sort(Comparator.comparing(Report::getCreated_at).reversed());
            List<Report> latest = new ArrayList<>();
            latest.add(reports.get(0));
            model.addAttribute("latestReport", latest);
        }

        List<Report> latest = reportService.getAllReports().stream()
                .filter(report -> !report.getProceeded())
                .sorted(Comparator.comparing(Report::getCreated_at).reversed())
                .toList();
        model.addAttribute("reviewed", latest);
        return "index";
    }
}
