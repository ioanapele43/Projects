package com.example.musify.controller;


import com.example.musify.dto.AlbumViewDTO;
import com.example.musify.dto.AlternativeTitlesDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.dto.SongViewDTO;
import com.example.musify.security.AdminVerify;
import com.example.musify.service.AlternativeTitlesService;
import com.example.musify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SongController {
    @Autowired
    private SongService songService;
    @Autowired
    private AlternativeTitlesService alternativeTitlesService;


    @GetMapping("/song")
    public List<SongViewDTO> getAllPlaylists() {
        return songService.getAllSongs();
    }

    @GetMapping("/song/{idSong}")
    public SongViewDTO getPlaylistById(@PathVariable Integer idSong) {
        return songService.getSongById(idSong);
    }

    @PostMapping("/song")
    public SongViewDTO createSong(@RequestBody @Valid SongDTO songDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return songService.createSong(songDTO);
    }

    @PutMapping("/song/{idSong}")
    public SongViewDTO updateSong(@PathVariable Integer idSong, @RequestBody @Valid SongDTO songDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return songService.updateSong(idSong, songDTO);
    }

    @DeleteMapping("/song/{idSong}")
    public void deleteSong(@PathVariable Integer idSong) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        songService.deleteSong(idSong);
    }

    @GetMapping("/song/{idSong}/alternativeTitles")
    public List<String> getAlternativeTitlesForASong(@PathVariable Integer idSong) {
        return alternativeTitlesService.getAlternativeTitlesForSong(idSong);
    }

    @PostMapping("/song/alternativeTitle")
    public AlternativeTitlesDTO addAlternativeTitle(@RequestBody @Valid AlternativeTitlesDTO alternativeTitle) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return alternativeTitlesService.createAlternativeTitle(alternativeTitle);
    }

    @GetMapping("songs/alternativeTitles")
    public List<AlternativeTitlesDTO> getAllAlternativeTitles() {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return alternativeTitlesService.getAllAternativeTitles();
    }
    @GetMapping("/song/artist/{idArtist}")
    public List<SongViewDTO> getAlbumsByArtist(@PathVariable Integer idArtist) {
        return songService.getAllSongsByArtist(idArtist);
    }

    @GetMapping("/song/band/{idBand}")
    public List<SongViewDTO> getAlbumsByBand(@PathVariable Integer idBand) {
        return songService.getAllSongsByBand(idBand);
    }

}
