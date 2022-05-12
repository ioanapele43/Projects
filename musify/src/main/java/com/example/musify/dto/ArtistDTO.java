package com.example.musify.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ArtistDTO {

    @NotBlank(message = "First name cannot be blank!")
    private String firstname;
    @NotBlank(message = "Last name cannot be blank!")
    private String lastname;
    @NotBlank(message = "Stage name cannot be blank!")
    private String stagename;
    private Date birthday;
    private Date activityStartDate;
    private Date activityEndDate;
}
