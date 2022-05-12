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
public class ArtistViewDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    private String stagename;
    private Date birthday;
    private Date activityStartDate;
    private Date activityEndDate;
}
