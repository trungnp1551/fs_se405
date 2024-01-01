package com.mobile.dashboard.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "notifications")
@Getter
@Setter
@RequiredArgsConstructor
public class Notification {
    @Id
    private String id;
    private String senderId;
    private String targetId;
    private String type;
    private String content;
    private Boolean read;

}
