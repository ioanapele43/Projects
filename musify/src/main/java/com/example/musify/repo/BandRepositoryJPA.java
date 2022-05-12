package com.example.musify.repo;

import com.example.musify.model.Artist;
import com.example.musify.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BandRepositoryJPA extends JpaRepository<Band, Integer> {
    Band getBandById(Integer id);

    List<Band> getBandByBandnameContainingIgnoreCase(String name);
}
