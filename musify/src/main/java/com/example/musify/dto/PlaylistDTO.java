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
public class PlaylistDTO {

    @NotBlank(message = "Name cannot be blank!")
    private String name;
    @NotBlank(message = "Type cannot be blank!")
    private String type;
    private Date createdDate;
    private Date lastUpdateDate;
}
