package com.mobile.dashboard.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "messages")
@Getter
@Setter
@RequiredArgsConstructor
public class Message {
    @Id
    private String id;
    private String sender_id;
    private String receiver_id;
    private Date created_at;
    private String content;
    private Boolean is_image = false;
    private String image_link = "";

}
