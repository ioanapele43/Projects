package com.example.musify.service;

import com.example.musify.dto.AlbumViewDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.dto.SongViewDTO;
import com.example.musify.exception.DataNotFoundException;
import com.example.musify.exception.WrongInputException;
import com.example.musify.model.Song;
import com.example.musify.repo.ArtistRepositoryJPA;
import com.example.musify.repo.BandRepositoryJPA;
import com.example.musify.repo.SongRepositoryJPA;
import com.example.musify.service.mappers.SongMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {
    private final SongRepositoryJPA songRepositoryJPA;
    private final ArtistRepositoryJPA artistRepositoryJPA;
    private final BandRepositoryJPA bandRepositoryJPA;
    private final SongMapper songMapper;
    private final ValidationsService validationsService;

    public SongService(SongRepositoryJPA songRepositoryJPA, ArtistRepositoryJPA artistRepositoryJPA, BandRepositoryJPA bandRepositoryJPA, SongMapper songMapper, ValidationsService validationsService) {
        this.songRepositoryJPA = songRepositoryJPA;
        this.artistRepositoryJPA = artistRepositoryJPA;
        this.bandRepositoryJPA = bandRepositoryJPA;
        this.songMapper = songMapper;
        this.validationsService = validationsService;
    }

    public List<SongViewDTO> getAllSongs() {
        return songRepositoryJPA.findAll()
                .stream()
                .map(songMapper::toViewDto)
                .collect(Collectors.toList());
    }

    public SongViewDTO getSongById(Integer id) {
        validationsService.checkIfASongExists(id);
        return songMapper.toViewDto(songRepositoryJPA.getSongById(id));
    }

    @Transactional
    public SongViewDTO createSong(SongDTO songDTO) {
        Song song=songMapper.toEntity(songDTO);
        if (songDTO.getIdBand() != 0 && songDTO.getIdArtist() != 0)
            throw new DataNotFoundException("an song cannot have multiple owners, just an artist or a band");
        if (songDTO.getIdBand() == 0 && songDTO.getIdArtist() == 0)
            throw new WrongInputException("an song should have at least one owner, artist or band");
        if (songDTO.getIdArtist() != 0) {
            validationsService.checkIfAnArtistExists(songDTO.getIdArtist());
            song.setArtist(artistRepositoryJPA.getArtistsById(songDTO.getIdArtist()));
        }

        if (songDTO.getIdBand() != 0) {
            validationsService.checkIfABandExists(songDTO.getIdBand());
            song.setBand(bandRepositoryJPA.getById(songDTO.getIdBand()));
        }
        Song songFromDatabase = songRepositoryJPA.save(song);
        return songMapper.toViewDto(songFromDatabase);
    }

    @Transactional
    public SongViewDTO updateSong(Integer id, SongDTO songDTO) {
        validationsService.checkIfASongExists(id);
        Song initial=songRepositoryJPA.getSongById(id);
        Song song = songMapper.toEntity(songDTO);
        song.setId(id);
        if (songDTO.getIdBand() != 0 && songDTO.getIdArtist() != 0)
            throw new DataNotFoundException("an song cannot have multiple owners, just an artist or a band");
        if (songDTO.getIdBand() == 0 && songDTO.getIdArtist() == 0)
            throw new WrongInputException("an song should have at least one owner, artist or band");
        if (songDTO.getIdArtist() != 0) {
            validationsService.checkIfAnArtistExists(songDTO.getIdArtist());
            song.setArtist(artistRepositoryJPA.getArtistsById(songDTO.getIdArtist()));
        }

        if (songDTO.getIdBand() != 0) {
            validationsService.checkIfABandExists(songDTO.getIdBand());
            song.setBand(bandRepositoryJPA.getById(songDTO.getIdBand()));
        }
        song.setAlbumSongs(initial.getAlbumSongs());
        song.setAlternativeTitles(initial.getAlternativeTitles());
        song.setPlaylistSongs(initial.getPlaylistSongs());
        Song songFromDatabase = songRepositoryJPA.save(song);
        return songMapper.toViewDto(songFromDatabase);
    }

    @Transactional
    public void deleteSong(Integer id) {
        validationsService.checkIfASongExists(id);
        songRepositoryJPA.delete(songRepositoryJPA.getSongById(id));
    }
    public List<SongViewDTO> getAllSongsByArtist(Integer idArtist) {
        validationsService.checkIfAnArtistExists(idArtist);
        return songRepositoryJPA.getSongsByArtist_Id(idArtist).stream()
                .map(songMapper::toViewDto)
                .collect(Collectors.toList());
    }

    public List<SongViewDTO> getAllSongsByBand(Integer idBand) {
        validationsService.checkIfABandExists(idBand);
        return songRepositoryJPA.getSongsByBand_Id(idBand).stream()
                .map(songMapper::toViewDto)
                .collect(Collectors.toList());
    }

}
