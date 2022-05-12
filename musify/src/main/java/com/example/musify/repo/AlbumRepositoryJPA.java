package com.example.musify.repo;

import com.example.musify.model.Album;
import com.example.musify.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepositoryJPA extends JpaRepository<Album, Integer> {
    Album getAlbumById(Integer id);

    List<Album> getAlbumsByArtist_Id(Integer id);

    List<Album> getAlbumsByBand_Id(Integer id);

    List<Album> findAlbumByTitleContainingIgnoreCase(String title);

}
