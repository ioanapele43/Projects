package com.example.musify.service.mappers;

import com.example.musify.dto.BandDTO;
import com.example.musify.dto.BandViewDTO;
import com.example.musify.model.Band;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BandMapper {
    BandDTO toDto(Band band);

    BandViewDTO toViewDto(Band band);

    Band toEntity(BandDTO bandDTO);
}
