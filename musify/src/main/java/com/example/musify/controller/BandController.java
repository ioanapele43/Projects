package com.example.musify.controller;

import com.example.musify.dto.ArtistViewDTO;
import com.example.musify.dto.BandDTO;
import com.example.musify.dto.BandViewDTO;
import com.example.musify.security.AdminVerify;
import com.example.musify.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BandController {

    @Autowired
    private BandService bandService;


    @GetMapping("/band")
    public List<BandViewDTO> getAllBands() {
        return bandService.getAllBands();
    }

    @PostMapping("/band")
    public BandViewDTO createBand(@RequestBody @Valid BandDTO bandDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return bandService.createBand(bandDTO);
    }

    @PutMapping("/band/{idBand}")
    public BandViewDTO updateBand(@PathVariable Integer idBand, @RequestBody @Valid BandDTO bandDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return bandService.updateBand(idBand, bandDTO);
    }

    @DeleteMapping("/band/{idBand}")
    public void deleteBand(@PathVariable Integer idBand) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        bandService.deleteBand(idBand);
    }

    @PostMapping("/band/{idBand}/{idArtist}")
    public List<ArtistViewDTO> addBandMember(@PathVariable Integer idBand, @PathVariable Integer idArtist) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return bandService.addBandMember(idBand, idArtist);
    }

    @GetMapping("/band/{idBand}/members")
    public List<ArtistViewDTO> getBandMembers(@PathVariable Integer idBand) {
        return bandService.getBandMembers(idBand);
    }


}
