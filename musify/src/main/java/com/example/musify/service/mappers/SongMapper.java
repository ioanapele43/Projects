package com.example.musify.service.mappers;

import com.example.musify.dto.SongDTO;
import com.example.musify.dto.SongViewDTO;
import com.example.musify.dto.UserViewDTO;
import com.example.musify.model.Song;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongMapper {
    SongDTO toDto(Song song);

    SongViewDTO toViewDto(Song song);

    Song toEntity(SongDTO songDTO);
}
