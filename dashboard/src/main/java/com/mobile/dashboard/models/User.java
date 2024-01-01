package com.mobile.dashboard.models;

import com.mobile.dashboard.enums.Role;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "users")
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
    private String phoneNumber;
    private String password;
    private Role role;
    private String emotion = "...";
    private String description = "...";
    private String gmail;
    private String id_fake;
    private List<String> listFriendId;
    private List<String> listPendingFriend;
    private List<String> listRecentConnect;
    private String token;
    private String resetTokenExpires;
    private List<String> listImage;
    private String yearOfB = "2001";
    private String sex = "male";
    private String settingId;
    private int reportNumber = 0;
    private Boolean banned = false;
    private String bannedDate;
}