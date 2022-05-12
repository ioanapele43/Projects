package com.example.musify.repo;

import com.example.musify.model.AlternativeTitles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlternativeTitlesRepositoryJPA extends JpaRepository<AlternativeTitles, Integer> {
    AlternativeTitles getAlternativeTitlesById(Integer id);

    List<AlternativeTitles> getAlternativeTitlesBySong_Id(Integer id);

    AlternativeTitles getAlternativeTitlesBySong_IdAndAlternativeTitle(Integer idSong, String alternativeTitle);

    List<AlternativeTitles> getAlternativeTitlesByAlternativeTitleContainingIgnoreCase(String input);

    void deleteAlternativeTitlesBySong_Id(Integer id);
}
