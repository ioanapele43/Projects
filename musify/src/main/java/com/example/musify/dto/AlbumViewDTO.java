package com.example.musify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlbumViewDTO {
    private Integer id;
    private String title;
    private String description;
    private String genre;
    private Date releaseDate;
    private String label;

}
