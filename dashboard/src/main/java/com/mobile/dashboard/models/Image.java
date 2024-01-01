package com.mobile.dashboard.models;

import com.mobile.dashboard.enums.Type;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "images")
@Getter
@Setter
@RequiredArgsConstructor
public class Image {
    @Id
    private String id;
    private String imageId;
    private String imageUrl;
    private String uploadTime;
    private Type type;

}
