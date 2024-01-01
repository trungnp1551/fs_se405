package com.mobile.dashboard.models;

import com.mobile.dashboard.enums.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "settings")
@Getter
@Setter
@RequiredArgsConstructor
public class Setting {
    @Id
    private String id;
    private Boolean sound;
    private Boolean vibration;
    private Boolean notification;
    private Status status;

}
