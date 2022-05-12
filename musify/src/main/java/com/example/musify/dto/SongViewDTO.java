package com.example.musify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SongViewDTO {
    private Integer id;
    private String title;
    private Time duration;
    private Date creationDate;


    @Override
    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(!(obj instanceof SongViewDTO))
            return false;
        SongViewDTO song=(SongViewDTO) obj;
        return (this.title.equals(song.getTitle()) );
    }
}
