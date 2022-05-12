package com.example.musify.service;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.ArtistViewDTO;
import com.example.musify.exception.WrongInputException;
import com.example.musify.model.Artist;
import com.example.musify.repo.ArtistRepositoryJPA;
import com.example.musify.repo.BandRepositoryJPA;
import com.example.musify.service.mappers.ArtistMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class ArtistService {
    private final ArtistRepositoryJPA artistRepository;
    private final BandRepositoryJPA bandRepositoryJPA;
    private final ArtistMapper artistMapper;
    private final ValidationsService validationsService;


    public ArtistService(ArtistRepositoryJPA artistRepository, BandRepositoryJPA bandRepositoryJPA, ArtistMapper artistMapper, ValidationsService validationsService) {
        this.artistRepository = artistRepository;
        this.bandRepositoryJPA = bandRepositoryJPA;
        this.artistMapper = artistMapper;
        this.validationsService = validationsService;
    }


    public List<ArtistViewDTO> getArtists() {
        return artistRepository.findAll()
                .stream()
                .map(artistMapper::toViewDto)
                .collect(Collectors.toList());
    }

    public ArtistViewDTO getArtistById(int id) {
        validationsService.checkIfAnArtistExists(id);
        return artistMapper.toViewDto(artistRepository.getArtistsById(id));
    }


    @Transactional
    public ArtistViewDTO saveArtist(ArtistDTO artist) {
        if (artist.getActivityEndDate().before(artist.getActivityStartDate()))
            throw new WrongInputException("the dates you entered are not in a correct order");
        Artist artistFromDatabase = artistRepository.save(artistMapper.toEntity(artist));
        return artistMapper.toViewDto(artistFromDatabase);
    }

    @Transactional
    public ArtistViewDTO updateArtist(Integer id, ArtistDTO artistDTO) {
        validationsService.checkIfAnArtistExists(id);
        Artist initial=artistRepository.getArtistsById(id);
        if (artistDTO.getActivityEndDate().before(artistDTO.getActivityStartDate()))
            throw new WrongInputException("the dates you entered are not in a correct order");
        Artist artist = artistMapper.toEntity(artistDTO);
        artist.setId(id);
        artist.setAlbums(initial.getAlbums());
        artist.setBandMember(initial.getBandMember());
        artist.setSongs(initial.getSongs());
        Artist artistFromDatabase = artistRepository.save(artist);
        return artistMapper.toViewDto(artistFromDatabase);
    }

    @Transactional
    public void deleteArtist(Integer id) {
        validationsService.checkIfAnArtistExists(id);
        Artist artist = artistRepository.getArtistsById(id);
        bandRepositoryJPA.findAll().forEach(band -> band.removeMember(artist));
        artistRepository.delete(artistRepository.getArtistsById(id));
    }


}
