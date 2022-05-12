package com.example.musify.service;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.AlbumViewDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.dto.SongViewDTO;
import com.example.musify.exception.DataNotFoundException;
import com.example.musify.exception.WrongInputException;
import com.example.musify.model.Album;
import com.example.musify.model.AlbumSongs;
import com.example.musify.repo.*;
import com.example.musify.service.mappers.AlbumMapper;
import com.example.musify.service.mappers.SongMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService {
    private final AlbumRepositoryJPA albumRepositoryJPA;
    private final ArtistRepositoryJPA artistRepositoryJPA;
    private final BandRepositoryJPA bandRepositoryJPA;
    private final AlbumSongsRepositoryJPA albumSongsRepositoryJPA;
    private final SongRepositoryJPA songRepositoryJPA;
    private final AlbumMapper albumMapper;
    private final SongMapper songMapper;
    private final ValidationsService validationsService;


    public AlbumService(AlbumRepositoryJPA albumRepositoryJPA, ArtistRepositoryJPA artistRepositoryJPA, BandRepositoryJPA bandRepositoryJPA, AlbumSongsRepositoryJPA albumSongsRepositoryJPA, SongRepositoryJPA songRepositoryJPA, AlbumMapper albumMapper, SongMapper songMapper, ValidationsService validationsService) {
        this.albumRepositoryJPA = albumRepositoryJPA;
        this.artistRepositoryJPA = artistRepositoryJPA;
        this.bandRepositoryJPA = bandRepositoryJPA;
        this.albumSongsRepositoryJPA = albumSongsRepositoryJPA;
        this.songRepositoryJPA = songRepositoryJPA;
        this.albumMapper = albumMapper;

        this.songMapper = songMapper;
        this.validationsService = validationsService;
    }

    public List<AlbumViewDTO> getAllAlbums() {
        return albumRepositoryJPA.findAll().stream()
                .map(albumMapper::toViewDto)
                .collect(Collectors.toList());
    }

    public List<AlbumViewDTO> getAllAlbumsByArtist(Integer idArtist) {
        validationsService.checkIfAnArtistExists(idArtist);
        return albumRepositoryJPA.getAlbumsByArtist_Id(idArtist).stream()
                .map(albumMapper::toViewDto)
                .collect(Collectors.toList());
    }

    public List<AlbumViewDTO> getAllAlbumsByBand(Integer idBand) {
        validationsService.checkIfABandExists(idBand);
        return albumRepositoryJPA.getAlbumsByBand_Id(idBand).stream()
                .map(albumMapper::toViewDto)
                .collect(Collectors.toList());
    }

    public AlbumViewDTO getAlbumById(Integer id) {
        validationsService.checkIfAnAlbumExists(id);
        return albumMapper.toViewDto(albumRepositoryJPA.getAlbumById(id));
    }

    @Transactional
    public AlbumViewDTO createAlbum(AlbumDTO albumDTO) throws DataNotFoundException {
        Album album = albumMapper.toEntity(albumDTO);
        if (albumDTO.getIdBand() != 0 && albumDTO.getIdArtist() != 0)
            throw new DataNotFoundException("an album cannot have multiple owners, just an artist or a band");
        if (albumDTO.getIdBand() == 0 && albumDTO.getIdArtist() == 0)
            throw new WrongInputException("an album should have at least one owner, artist or band");
        if (albumDTO.getIdArtist() != 0) {
            validationsService.checkIfAnArtistExists(albumDTO.getIdArtist());
            album.setArtist(artistRepositoryJPA.getArtistsById(albumDTO.getIdArtist()));
        }

        if (albumDTO.getIdBand() != 0) {
            validationsService.checkIfABandExists(albumDTO.getIdBand());
            album.setBand(bandRepositoryJPA.getById(albumDTO.getIdBand()));
        }

        Album albumFromDatabase = albumRepositoryJPA.save(album);
        return albumMapper.toViewDto(albumFromDatabase);
    }

    @Transactional
    public AlbumViewDTO updateAlbum(Integer id, AlbumDTO albumDTO) {
        if (albumRepositoryJPA.getAlbumById(id) == null)
            throw new DataNotFoundException("the album you want to update doesn't exist");
        Album initial=albumRepositoryJPA.getAlbumById(id);
        Album album = albumMapper.toEntity(albumDTO);
        album.setId(id);
        if (albumDTO.getIdBand() != 0 && albumDTO.getIdArtist() != 0)
            throw new DataNotFoundException("an album cannot have multiple owners, just an artist or a band");
        if (albumDTO.getIdArtist() != 0) {
            validationsService.checkIfAnArtistExists(albumDTO.getIdArtist());
            album.setArtist(artistRepositoryJPA.getArtistsById(albumDTO.getIdArtist()));
        }

        if (albumDTO.getIdBand() != 0) {
            validationsService.checkIfABandExists(albumDTO.getIdBand());
            album.setBand(bandRepositoryJPA.getById(albumDTO.getIdBand()));
        }
        album.setAlbumSongs(initial.getAlbumSongs());
        Album albumFromDatabase = albumRepositoryJPA.save(album);
        return albumMapper.toViewDto(albumFromDatabase);
    }

    @Transactional
    public void deleteAlbum(Integer id) {
        validationsService.checkIfAnAlbumExists(id);
        albumRepositoryJPA.delete(albumRepositoryJPA.getAlbumById(id));
    }

    @Transactional
    public List<SongViewDTO> getAlbumSongs(Integer id) {
        validationsService.checkIfAnAlbumExists(id);
        return albumSongsRepositoryJPA.getAlbumSongsByAlbum_Id(id)
                .stream()
                .sorted(Comparator.comparing(AlbumSongs::getOrderNumber))
                .map(as -> songMapper.toViewDto(as.getSong()))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<SongViewDTO> addSongToAlbum(Integer idAlbum, Integer idSong) {
        AlbumSongs albumSong = new AlbumSongs();

        validationsService.checkIfASongExists(idSong);
        validationsService.checkIfAnAlbumExists(idAlbum);
        validationsService.checkIfASongIsNOTInAnAlbum(idAlbum, idSong);

        albumSong.setSong(songRepositoryJPA.getSongById(idSong));
        albumSong.setAlbum(albumRepositoryJPA.getAlbumById(idAlbum));
        albumSong.setOrderNumber(albumSongsRepositoryJPA.getAlbumSongsByAlbum_Id(idAlbum).size() + 1);
        albumSongsRepositoryJPA.save(albumSong);
        return albumSongsRepositoryJPA.getAlbumSongsByAlbum_Id(idAlbum)
                .stream()
                .map(as -> songMapper.toViewDto(as.getSong()))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<SongViewDTO> changeSongOrderNumber(Integer idAlbum, Integer idSong, Integer newOrderNumber) {

        validationsService.checkIfASongExists(idSong);
        validationsService.checkIfAnAlbumExists(idAlbum);
        validationsService.checkIfASongIsInAnAlbum(idAlbum, idSong);

        Integer oldOrderNumber = albumSongsRepositoryJPA.getAlbumSongsByAlbum_IdAndSong_id(idAlbum, idSong).getOrderNumber();
        List<AlbumSongs> albumSongs = albumSongsRepositoryJPA.getAlbumSongsByAlbum_Id(idAlbum);
        if (albumSongs.size() < newOrderNumber)
            throw new WrongInputException("New order number is too large");
        albumSongs.forEach(album -> {
            if (oldOrderNumber < newOrderNumber) {
                if (album.getOrderNumber() > oldOrderNumber && album.getOrderNumber() <= newOrderNumber)
                    album.setOrderNumber(album.getOrderNumber() - 1);
            } else {
                if (album.getOrderNumber() < oldOrderNumber && album.getOrderNumber() >= newOrderNumber) {
                    album.setOrderNumber(album.getOrderNumber() + 1);
                }
            }
        });
        albumSongsRepositoryJPA.getAlbumSongsByAlbum_IdAndSong_id(idAlbum, idSong).setOrderNumber(newOrderNumber);
        return albumSongsRepositoryJPA.getAlbumSongsByAlbum_Id(idAlbum)
                .stream()
                .sorted(Comparator.comparing(AlbumSongs::getOrderNumber))
                .map(as -> songMapper.toViewDto(as.getSong()))
                .collect(Collectors.toList());
    }
}
