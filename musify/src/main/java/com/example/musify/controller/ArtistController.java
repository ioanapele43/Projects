package com.example.musify.controller;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.ArtistViewDTO;
import com.example.musify.security.AdminVerify;
import com.example.musify.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
public class ArtistController {
    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artist")
    public List<ArtistViewDTO> getAllArtist() {
        return artistService.getArtists();
    }

    @GetMapping("/artist/{idArtist}")
    public ArtistViewDTO getArtistByID(@PathVariable Integer idArtist) {
        return artistService.getArtistById(idArtist);
    }

    @PostMapping("/artist")
    public ArtistViewDTO saveArtist(@RequestBody @Valid ArtistDTO artistDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return artistService.saveArtist(artistDTO);
    }

    @PutMapping("/artist/{idArtist}")
    public ArtistViewDTO updateArtist(@PathVariable Integer idArtist, @RequestBody @Valid ArtistDTO artistDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return artistService.updateArtist(idArtist, artistDTO);
    }

    @DeleteMapping("/artist/{idArtist}")
    public void deleteArtist(@PathVariable Integer idArtist) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        artistService.deleteArtist(idArtist);
    }
}
