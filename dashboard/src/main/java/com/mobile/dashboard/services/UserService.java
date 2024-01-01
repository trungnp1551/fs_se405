package com.mobile.dashboard.services;

import com.mobile.dashboard.models.User;
import com.mobile.dashboard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if (optional.isPresent()) user = optional.get();
        else throw new RuntimeException("User not found");
        return user;
    }

    public void banUser(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setBanned(true);
            user.setBannedDate(LocalDateTime.now().toString());
            userRepository.save(user);
        }
    }

    public void unbanUser(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setBanned(false);
            user.setBannedDate("");
            userRepository.save(user);
        }
    }
}
