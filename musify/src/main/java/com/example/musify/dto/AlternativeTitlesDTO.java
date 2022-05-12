package com.example.musify.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlternativeTitlesDTO {
    private Integer id;
    @NotBlank(message = "Alternative title cannot be blank!")
    private String alternativeTitle;
    private Integer idSong;

}
