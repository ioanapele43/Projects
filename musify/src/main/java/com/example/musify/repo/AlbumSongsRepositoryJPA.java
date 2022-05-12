package com.example.musify.repo;

import com.example.musify.model.AlbumSongs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumSongsRepositoryJPA extends JpaRepository<AlbumSongs, Integer> {
    AlbumSongs getAlbumSongsById(Integer id);

    List<AlbumSongs> getAlbumSongsByAlbum_Id(Integer id);

    AlbumSongs getAlbumSongsByAlbum_IdAndSong_id(Integer idAlbum, Integer idSong);

    void deleteAlbumSongsByAlbum_Id(Integer id);

    void deleteAlbumSongsBySong_Id(Integer id);

}
