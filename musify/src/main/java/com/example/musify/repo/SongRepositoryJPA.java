package com.example.musify.repo;

import com.example.musify.model.Album;
import com.example.musify.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepositoryJPA extends JpaRepository<Song, Integer> {
    Song getSongById(Integer id);
    List<Song> getSongsByArtist_Id(Integer id);

    List<Song> getSongsByBand_Id(Integer id);

    List<Song> getSongByTitleContainingIgnoreCase(String title);
}
