package com.example.musify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BandDTO {

    @NotBlank(message = "Band name cannot be blank!")
    private String bandname;
    @NotBlank(message = "Location cannot be blank!")
    private String location;
    private Date activityStartDate;
    private Date activityEndDate;

}
