package com.example.musify.service.mappers;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.ArtistViewDTO;
import com.example.musify.model.Artist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArtistMapper {
    ArtistDTO toDto(Artist artist);

    ArtistViewDTO toViewDto(Artist artist);

    Artist toEntity(ArtistDTO artistDTO);
}
