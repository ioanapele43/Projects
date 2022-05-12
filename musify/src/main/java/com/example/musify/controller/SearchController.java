package com.example.musify.controller;

import com.example.musify.dto.*;
import com.example.musify.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping("/search/artists/{name}")
    public List<ArtistViewDTO> searchArtistsByName(@PathVariable String name) {
        return searchService.searchByName(name);
    }

    @GetMapping("/search/albums/{title}")
    public List<AlbumViewDTO> searchAlbumByTitle(@PathVariable String title) {
        return searchService.searchByTitle(title);
    }

    @GetMapping("/search/bands/{bandname}")
    public List<BandViewDTO> searchBandByBandName(@PathVariable String bandname) {
        return searchService.searchByBandname(bandname);
    }

    @GetMapping("/search/songs/{alternativeTitles}")
    public List<SongViewDTO> searchSongByAlternativeTitle(@PathVariable String alternativeTitle) {
        return searchService.searchSongsByAlternativeTitle(alternativeTitle);
    }

    @GetMapping("/search/songs/{title}")
    public List<SongViewDTO> searchSongsByTitle(@PathVariable String title) {
        return searchService.searchSongByTitle(title);
    }

    @GetMapping("/search/{input}")
    public ResponseEntity<SearchDTO> searchAll(@PathVariable String input) {
        SearchDTO searchDTO = searchService.searchAll(input);
        return new ResponseEntity<>(searchDTO, HttpStatus.OK);
    }

}
