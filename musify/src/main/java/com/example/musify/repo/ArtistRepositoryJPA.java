package com.example.musify.repo;

import com.example.musify.model.Artist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepositoryJPA extends JpaRepository<Artist, Integer> {
    Artist findByFirstname(String firstname);

    Artist getArtistsById(Integer id);

    List<Artist> getArtistsByFirstnameContainingIgnoreCase(String name);

    List<Artist> getArtistsByLastnameContainingIgnoreCase(String name);

    List<Artist> getArtistsByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrStagenameContainingIgnoreCase(String firstname, String lastname,String stagename);
}
