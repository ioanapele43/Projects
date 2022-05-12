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

public class AlbumDTO {
    @NotBlank(message = "Title cannot be blank!")
    private String title;
    @NotBlank(message = "Description cannot be blank!")
    private String description;
    @NotBlank(message = "Genre cannot be blank!")
    private String genre;
    private Date releaseDate;
    @NotBlank(message = "Message cannot be blank!")
    private String label;
    private Integer idArtist;
    private Integer idBand;

}
