package com.example.musify.service;

import com.example.musify.exception.DataNotFoundException;
import com.example.musify.exception.PrivatePlaylistException;
import com.example.musify.repo.*;
import com.example.musify.security.JwtUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidationsService {
    private final AlbumRepositoryJPA albumRepositoryJPA;
    private final AlbumSongsRepositoryJPA albumSongsRepositoryJPA;
    private final AlternativeTitlesRepositoryJPA alternativeTitlesRepositoryJPA;
    private final ArtistRepositoryJPA artistRepositoryJPA;
    private final BandRepositoryJPA bandRepositoryJPA;
    private final PlaylistRepositoryJPA playlistRepositoryJPA;
    private final PlaylistSongsRepositoryJPA playlistSongsRepositoryJPA;
    private final SongRepositoryJPA songRepositoryJPA;
    private final UserRepositoryJPA userRepositoryJPA;


    public ValidationsService(AlbumRepositoryJPA albumRepositoryJPA, AlbumSongsRepositoryJPA albumSongsRepositoryJPA, AlternativeTitlesRepositoryJPA alternativeTitlesRepositoryJPA, ArtistRepositoryJPA artistRepositoryJPA, BandRepositoryJPA bandRepositoryJPA, PlaylistRepositoryJPA playlistRepositoryJPA, PlaylistSongsRepositoryJPA playlistSongsRepositoryJPA, SongRepositoryJPA songRepositoryJPA, UserRepositoryJPA userRepositoryJPA) {
        this.albumRepositoryJPA = albumRepositoryJPA;
        this.albumSongsRepositoryJPA = albumSongsRepositoryJPA;
        this.alternativeTitlesRepositoryJPA = alternativeTitlesRepositoryJPA;
        this.artistRepositoryJPA = artistRepositoryJPA;
        this.bandRepositoryJPA = bandRepositoryJPA;
        this.playlistRepositoryJPA = playlistRepositoryJPA;
        this.playlistSongsRepositoryJPA = playlistSongsRepositoryJPA;
        this.songRepositoryJPA = songRepositoryJPA;
        this.userRepositoryJPA = userRepositoryJPA;
    }

    public void checkIfAnAlbumExists(Integer id) {
        if (albumRepositoryJPA.getAlbumById(id) == null)
            throw new DataNotFoundException("the album you entered does not exist");
    }

    public void checkIfASongIsInAnAlbum(Integer idAlbum, Integer idSong) {
        if (albumSongsRepositoryJPA.getAlbumSongsByAlbum_IdAndSong_id(idAlbum, idSong) == null)
            throw new DataNotFoundException("the song is not in the album you entered");
    }

    public void checkIfASongIsNOTInAnAlbum(Integer idAlbum, Integer idSong) {
        if (albumSongsRepositoryJPA.getAlbumSongsByAlbum_IdAndSong_id(idAlbum, idSong) != null)
            throw new DataNotFoundException("the song is in the album you entered");
    }

    public void checkIfAnArtistExists(Integer id) {
        if (artistRepositoryJPA.getArtistsById(id) == null)
            throw new DataNotFoundException("the artist you entered does not exist");
    }

    public void checkIfABandExists(Integer id) {
        if (bandRepositoryJPA.getBandById(id) == null)
            throw new DataNotFoundException("the band you entered does not exist");
    }

    public void checkIfAPlaylistExists(Integer id) {
        if (playlistRepositoryJPA.getPlaylistById(id) == null)
            throw new DataNotFoundException("the playlist you entered does not exist");
    }

    public void checkIfASongIsInAPlaylist(Integer idPlaylist, Integer idSong) {
        if (playlistSongsRepositoryJPA.getPlaylistSongsByPlaylist_IdAndSong_Id(idPlaylist, idSong) == null)
            throw new DataNotFoundException("the song is not in the playlist");
    }

    public void checkIfASongIsNOTInAPlaylist(Integer idPlaylist, Integer idSong) {
        if (playlistSongsRepositoryJPA.getPlaylistSongsByPlaylist_IdAndSong_Id(idPlaylist, idSong) != null)
            throw new DataNotFoundException("the song is already in the playlist");
    }

    public void checkIfASongExists(Integer id) {
        if (songRepositoryJPA.getSongById(id) == null)
            throw new DataNotFoundException("the song you entered does not exist");
    }

    public void checkIfAUserExists(Integer id) {
        if (userRepositoryJPA.getUserById(id) == null)
            throw new DataNotFoundException("the user you entered does not exist");
    }

    public void checkIfAnAlternativeTitleExists(Integer id) {
        if (alternativeTitlesRepositoryJPA.getAlternativeTitlesById(id) == null)
            throw new DataNotFoundException("the album you entered does not exist");
    }

    public void checkIfASongAlreadyHasAnAlternativeTitle(Integer idSong, String title) {
        if (alternativeTitlesRepositoryJPA.getAlternativeTitlesBySong_IdAndAlternativeTitle(idSong, title) != null)
            throw new DataNotFoundException("the song already has this alternative title");
    }

    public void checkIfAUserIsTheOwnerOfAPlaylist(Integer idPlaylist) {
        if (playlistRepositoryJPA.getPlaylistById(idPlaylist).getOwner() != userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId()))
            throw new PrivatePlaylistException("this playlist is not yours!");
    }

    public void checkIfAUserCanAccessAPlaylist(Integer idPlaylist) {
        if (playlistRepositoryJPA.getPlaylistById(idPlaylist).getType().equals("private") && playlistRepositoryJPA.getPlaylistById(idPlaylist).getOwner() != userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId()))
            throw new PrivatePlaylistException("this playlist is private, you cannot access others private playlists!");
    }


}
