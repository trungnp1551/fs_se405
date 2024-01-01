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

@Controller
public class AppController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private UserService userService;


    @GetMapping("/dashboard")
    public String showTables(Model model) {
        List<User> users = userService.getAllUsers();
        users.sort(Comparator.comparing(User::getBannedDate).reversed());
        List<User> bannedList = new ArrayList<>();
        if (!users.isEmpty()) {
            bannedList.add(users.get(0));
            model.addAttribute("bannedList", bannedList);
        }

        List<Report> reports = reportService.getAllReports();
        reports.sort(Comparator.comparing(Report::getCreated_at).reversed());
        List<Report> latest = new ArrayList<>();
        if (!reports.isEmpty()) {
            latest.add(reports.get(0));
            model.addAttribute("latestReport", latest);
        }
        return "index";
    }
}
