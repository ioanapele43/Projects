package com.example.musify.service;

import com.example.musify.dto.ArtistViewDTO;
import com.example.musify.dto.BandDTO;
import com.example.musify.dto.BandViewDTO;
import com.example.musify.exception.AlreadyExistingDataException;
import com.example.musify.exception.WrongInputException;
import com.example.musify.model.Band;
import com.example.musify.repo.ArtistRepositoryJPA;
import com.example.musify.repo.BandRepositoryJPA;
import com.example.musify.service.mappers.ArtistMapper;
import com.example.musify.service.mappers.BandMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BandService {
    private final BandRepositoryJPA bandRepositoryJPA;
    private final BandMapper bandMapper;
    private final ArtistRepositoryJPA artistRepositoryJPA;
    private final ArtistMapper artistMapper;
    private final ValidationsService validationsService;

    public BandService(BandRepositoryJPA bandRepositoryJPA, BandMapper bandMapper, ArtistRepositoryJPA artistRepositoryJPA, ArtistMapper artistMapper, ValidationsService validationsService) {
        this.bandRepositoryJPA = bandRepositoryJPA;
        this.bandMapper = bandMapper;
        this.artistRepositoryJPA = artistRepositoryJPA;
        this.artistMapper = artistMapper;
        this.validationsService = validationsService;
    }

    public List<BandViewDTO> getAllBands() {
        return bandRepositoryJPA.findAll()
                .stream()
                .map(bandMapper::toViewDto)
                .collect(Collectors.toList());
    }

    public BandViewDTO getBandById(Integer id) {
        validationsService.checkIfABandExists(id);
        return bandMapper.toViewDto(bandRepositoryJPA.getBandById(id));
    }

    @Transactional
    public BandViewDTO createBand(BandDTO bandDTO) {
        if (bandDTO.getActivityEndDate().before(bandDTO.getActivityStartDate()))
            throw new WrongInputException("the dates you entered are not in a correct order");
        Band bandFromDatabese = bandRepositoryJPA.save(bandMapper.toEntity(bandDTO));
        return bandMapper.toViewDto(bandFromDatabese);
    }

    @Transactional
    public BandViewDTO updateBand(Integer id, BandDTO bandDTO) {
        validationsService.checkIfABandExists(id);
        Band initial=bandRepositoryJPA.getBandById(id);
        if (bandDTO.getActivityEndDate().before(bandDTO.getActivityStartDate()))
            throw new WrongInputException("the dates you entered are not in a correct order");
        Band band = bandMapper.toEntity(bandDTO);
        band.setId(id);
        band.setAlbums(initial.getAlbums());
        band.setMembers(initial.getMembers());
        band.setSongs(initial.getSongs());
        Band bandFromDatabese = bandRepositoryJPA.save(band);
        return bandMapper.toViewDto(bandFromDatabese);
    }

    @Transactional
    public void deleteBand(Integer id) {
        validationsService.checkIfABandExists(id);
        bandRepositoryJPA.delete(bandRepositoryJPA.getBandById(id));
    }

    @Transactional
    public List<ArtistViewDTO> addBandMember(Integer idBand, Integer idArtist) {
        validationsService.checkIfABandExists(idBand);
        validationsService.checkIfAnArtistExists(idArtist);

        Band band = bandRepositoryJPA.getBandById(idBand);
        if (band.getMembers().contains(artistRepositoryJPA.getArtistsById(idArtist)))
            throw new AlreadyExistingDataException("the member is already added");
        band.addMember(artistRepositoryJPA.getArtistsById(idArtist));
        return band.getMembers()
                .stream()
                .map(artistMapper::toViewDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ArtistViewDTO> getBandMembers(Integer id) {
        validationsService.checkIfABandExists(id);
        return bandRepositoryJPA.getBandById(id).getMembers()
                .stream()
                .map(artistMapper::toViewDto)
                .collect(Collectors.toList());
    }

}
