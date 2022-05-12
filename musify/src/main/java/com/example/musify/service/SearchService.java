package com.example.musify.service;

import com.example.musify.dto.*;
import com.example.musify.model.AlternativeTitles;
import com.example.musify.model.Song;
import com.example.musify.repo.*;
import com.example.musify.service.mappers.AlbumMapper;
import com.example.musify.service.mappers.ArtistMapper;
import com.example.musify.service.mappers.BandMapper;
import com.example.musify.service.mappers.SongMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final ArtistRepositoryJPA artistRepositoryJPA;
    private final BandRepositoryJPA bandRepositoryJPA;
    private final AlbumRepositoryJPA albumRepositoryJPA;
    private final SongRepositoryJPA songRepositoryJPA;
    private final SongMapper songMapper;
    private final ArtistMapper artistMapper;
    private final BandMapper bandMapper;
    private final AlbumMapper albumMapper;
    private final ValidationsService validationsService;
    private final AlternativeTitlesRepositoryJPA alternativeTitlesRepositoryJPA;

    public SearchService(ArtistRepositoryJPA artistRepositoryJPA, BandRepositoryJPA bandRepositoryJPA, AlbumRepositoryJPA albumRepositoryJPA, SongRepositoryJPA songRepositoryJPA, SongMapper songMapper, ArtistMapper artistMapper, BandMapper bandMapper, AlbumMapper albumMapper, ValidationsService validationsService, AlternativeTitlesRepositoryJPA alternativeTitlesRepositoryJPA) {
        this.artistRepositoryJPA = artistRepositoryJPA;
        this.bandRepositoryJPA = bandRepositoryJPA;
        this.albumRepositoryJPA = albumRepositoryJPA;
        this.songRepositoryJPA = songRepositoryJPA;
        this.songMapper = songMapper;
        this.artistMapper = artistMapper;
        this.bandMapper = bandMapper;
        this.albumMapper = albumMapper;
        this.validationsService = validationsService;
        this.alternativeTitlesRepositoryJPA = alternativeTitlesRepositoryJPA;
    }

    @Transactional
    public List<ArtistViewDTO> searchByName(String name) {
       // return artistRepositoryJPA.findArtistByFirstnameOrLastname("%" + name + "%").stream().map(a -> artistMapper.toViewDto(a)).collect(Collectors.toList());
        return artistRepositoryJPA.getArtistsByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrStagenameContainingIgnoreCase(name,name,name)
                .stream()
                .map(artistMapper::toViewDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<BandViewDTO> searchByBandname(String bandname) {
        return bandRepositoryJPA.getBandByBandnameContainingIgnoreCase(bandname)
                .stream()
                .map(bandMapper::toViewDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<AlbumViewDTO> searchByTitle(String title) {
        return albumRepositoryJPA.findAlbumByTitleContainingIgnoreCase(title)
                .stream()
                .map(albumMapper::toViewDto)
                .collect(Collectors.toList());
    }
    @Transactional
    public List<SongViewDTO> searchSongByTitle(String title){
        return songRepositoryJPA.getSongByTitleContainingIgnoreCase(title)
                .stream()
                .map(songMapper::toViewDto)
                .collect(Collectors.toList());
    }
    @Transactional
    public List<SongViewDTO> searchSongsByAlternativeTitle(String alternativeTitle){
        List<Song> songs=alternativeTitlesRepositoryJPA.getAlternativeTitlesByAlternativeTitleContainingIgnoreCase(alternativeTitle).stream().map(AlternativeTitles::getSong).distinct().collect(Collectors.toList());
        return songs.stream()
                .distinct()
                .map(songMapper::toViewDto)
                .collect(Collectors.toList());
       }

    @Transactional
    public SearchDTO searchAll(String input) {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setAlbums(albumRepositoryJPA.findAlbumByTitleContainingIgnoreCase(input)
                                                .stream()
                                                .map(albumMapper::toViewDto)
                                                .collect(Collectors.toList()));
        searchDTO.setArtists(artistRepositoryJPA.getArtistsByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrStagenameContainingIgnoreCase(input,input,input)
                                                .stream()
                                                .map(artistMapper::toViewDto)
                                                .collect(Collectors.toList()));
        searchDTO.setBands(bandRepositoryJPA.getBandByBandnameContainingIgnoreCase(input)
                                            .stream()
                                            .map(bandMapper::toViewDto)
                                            .collect(Collectors.toList()));
        searchDTO.setSongs(songRepositoryJPA.getSongByTitleContainingIgnoreCase(input)
                                            .stream()
                                            .map(songMapper::toViewDto)
                                            .collect(Collectors.toList()));
        List<Song> songs=alternativeTitlesRepositoryJPA.getAlternativeTitlesByAlternativeTitleContainingIgnoreCase(input)
                                                        .stream()
                                                        .map(AlternativeTitles::getSong)
                                                        .distinct()
                                                        .collect(Collectors.toList());
        searchDTO.setSongsByAlternativeTitle( songs.stream()
                                                    .distinct()
                                                    .map(songMapper::toViewDto)
                                                    .collect(Collectors.toList()));
        return searchDTO;
    }

}
