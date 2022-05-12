package com.example.musify.service.mappers;

import com.example.musify.dto.AlternativeTitlesDTO;
import com.example.musify.model.AlternativeTitles;
import com.example.musify.model.Song;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlternativeTitlesMapper {
    AlternativeTitlesDTO toDto(AlternativeTitles alternativeTitles);

    AlternativeTitles toEntity(AlternativeTitlesDTO alternativeTitlesDTO);
}
