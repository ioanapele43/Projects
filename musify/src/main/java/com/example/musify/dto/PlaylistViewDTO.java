package com.example.musify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlaylistViewDTO {
    private Integer id;
    private String name;
    private String type;
    private Date createdDate;
    private Date lastUpdateDate;
}
