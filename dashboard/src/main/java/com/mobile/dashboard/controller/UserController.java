package com.mobile.dashboard.controller;

import com.mobile.dashboard.models.User;
import com.mobile.dashboard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String showUser(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "users";
    }

    @GetMapping("/ban/{id}")
    public String banUser(@PathVariable String id) {
        userService.banUser(id);
        return "users";
    }

    @GetMapping("/unban/{id}")
    public String unbanUser(@PathVariable String id) {
        userService.unbanUser(id);
        return "users";
    }

}
