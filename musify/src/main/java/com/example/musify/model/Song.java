package com.example.musify.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "songs")
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "duration")
    private Time duration;
    @Column(name = "creation_date")
    private Date creationDate;

    @ManyToOne
    private Artist artist;

    @ManyToOne
    private Band band;


    @OneToMany(mappedBy = "song", orphanRemoval = true)
    private List<AlternativeTitles> alternativeTitles;


    @OneToMany(mappedBy = "song", orphanRemoval = true)
    private List<AlbumSongs> albumSongs;
    @OneToMany(mappedBy = "song", orphanRemoval = true)
    private List<PlaylistSongs> playlistSongs;

    public Song(String title, Time duration, Date creationDate) {
        this.title = title;
        this.duration = duration;
        this.creationDate = creationDate;
    }

    public void addAlternativeTitle(AlternativeTitles alternativeTitle) {
        alternativeTitles.add(alternativeTitle);
    }

}
