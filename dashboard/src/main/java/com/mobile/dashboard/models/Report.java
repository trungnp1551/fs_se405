package com.mobile.dashboard.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@Document(collection = "reports")
@Getter
@Setter
@RequiredArgsConstructor
public class Report {
    @Id
    private String id;
    private String sender_id;
    private String target_id;
    private String content;
    private Date created_at;
    private Boolean proceeded = false;
    private String message_id;

}
