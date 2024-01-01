package com.mobile.dashboard.models;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "musics")
@Getter
@Setter
@RequiredArgsConstructor
public class Music {
    @Id
    private String id;
    private String title;
    private String musicUrl;

}
