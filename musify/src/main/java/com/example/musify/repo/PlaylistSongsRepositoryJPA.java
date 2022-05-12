package com.example.musify.repo;

import com.example.musify.model.PlaylistSongs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistSongsRepositoryJPA extends JpaRepository<PlaylistSongs, Integer> {
    PlaylistSongs getPlaylistSongsById(Integer id);

    List<PlaylistSongs> getPlaylistSongsByPlaylist_Id(Integer id);

    PlaylistSongs getPlaylistSongsByPlaylist_IdAndSong_Id(Integer idPlaylist, Integer idSong);

    void deletePlaylistSongsByPlaylist_Id(Integer id);

    void deletePlaylistSongsBySong_Id(Integer id);
}
