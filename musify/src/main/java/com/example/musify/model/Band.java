package com.example.musify.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "band")
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "band_name")
    private String bandname;
    @Column(name = "location")
    private String location;
    @Column(name = "activity_start_date")
    private Date activityStartDate;
    @Column(name = "activity_end_date")
    private Date activityEndDate;

    @ManyToMany
    @JoinTable(
            name = "members",
            joinColumns = @JoinColumn(name = "band_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Artist> members;

   /* @OneToMany
    private List<Album> album=new ArrayList<Album>();*/


    /*@OneToMany(mappedBy = "artistId")
    private List<SongArtist> songArtist;*/

    @OneToMany(mappedBy = "band", orphanRemoval = true)
    private List<Album> albums;
    @OneToMany(mappedBy = "band", orphanRemoval = true)
    private List<Song> songs;

    public Band(Integer idBand, String bandname, String location, Date startDate, Date endDate) {
        this.id = idBand;
        this.bandname = bandname;
        this.location = location;
        this.activityStartDate = startDate;
        this.activityEndDate = endDate;
    }

    public void addMember(Artist artist) {
        members.add(artist);
    }

    public void removeMember(Artist artist) {
        members.remove(artist);
    }
}
