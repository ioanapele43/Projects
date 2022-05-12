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
public class BandViewDTO {
    private Integer id;
    private String bandname;
    private String location;
    private Date activityStartDate;
    private Date activityEndDate;

}
