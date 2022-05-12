package com.example.musify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SongDTO {

    @NotBlank(message = "Title cannot be blank!")
    private String title;
    private Time duration;
    private Date creationDate;
    private Integer idArtist;
    private Integer idBand;
}
