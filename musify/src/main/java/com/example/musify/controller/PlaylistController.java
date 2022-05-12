package com.example.musify.controller;

import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.PlaylistViewDTO;
import com.example.musify.dto.SongViewDTO;
import com.example.musify.security.AdminVerify;
import com.example.musify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/playlist")
    public List<PlaylistViewDTO> getAllPlaylists() {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/playlist/{idPlaylist}")
    public PlaylistViewDTO getPlaylistById(@PathVariable Integer idPlaylist) {
        return playlistService.getPlaylistbyId(idPlaylist);
    }

    @PostMapping("/playlist")
    public PlaylistViewDTO createPlaylist(@RequestBody @Valid PlaylistDTO playlistDTO) {
        return playlistService.createPlaylist(playlistDTO);
    }

    @PutMapping("/playlist/{idPlaylist}")
    public PlaylistViewDTO updatePlaylist(@PathVariable Integer idPlaylist, @RequestBody @Valid PlaylistDTO playlistDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return playlistService.updatePlaylist(idPlaylist, playlistDTO);
    }

    @DeleteMapping("/playlist/{idPlaylist}")
    public void deletePlaylist(@PathVariable Integer idPlaylist) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        playlistService.deletePlaylist(idPlaylist);
    }

    @PostMapping("/playlist/{idPlaylist}/Song/{idSong}")
    public List<SongViewDTO> addSongToPlaylist(@PathVariable Integer idPlaylist, @PathVariable Integer idSong) {
        return playlistService.addSongToPlaylist(idPlaylist, idSong);
    }


    @PostMapping("/playlist/{id}/follow")
    public List<PlaylistViewDTO> followPlaylist(@PathVariable Integer id) {
        return playlistService.followPlaylistByCurrentUser(id);
    }

    @PostMapping("/playlist/{id}/unfollow")
    public List<PlaylistViewDTO> unfollowPlaylist(@PathVariable Integer id) {
        return playlistService.unfollowPlaylistByCurrentUser(id);
    }

    @PostMapping("/playlist/{idPlaylist}/album/{idAlbum}")
    public List<SongViewDTO> addSongFromAnAlbum(@PathVariable Integer idPlaylist, @PathVariable Integer idAlbum) {
        return playlistService.addAlbumSongsToPlaylist(idPlaylist, idAlbum);
    }

    @PutMapping("/playlist/{idPlaylist}/{idSong}/{newOrderNumber}")
    public List<SongViewDTO> changeSongsOrder(@PathVariable Integer idPlaylist, @PathVariable Integer idSong, @PathVariable Integer newOrderNumber) {
        return playlistService.changeSongOrderNumber(idPlaylist, idSong, newOrderNumber);
    }

    @GetMapping("/playlist/{idPlaylist}/songs")
    public List<SongViewDTO> getPlaylistSongs(@PathVariable Integer idPlaylist) {
        return playlistService.getPlaylistSongs(idPlaylist);
    }
    @GetMapping("/playlist/created")
    public List<PlaylistViewDTO> getPlaylistsCreated() {
        return playlistService.getPlaylistCreatedByTheCurrentUser();
    }

    @GetMapping("/playlist/followed")
    public List<PlaylistViewDTO> getPlaylistsFollowed() {
        return playlistService.getPlaylistFollowedByTheCurrentUser();
    }

}
