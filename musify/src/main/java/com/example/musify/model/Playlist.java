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
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "playlist_name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "last_update_date")
    private Date lastUpdateDate;

    @ManyToOne
    private User owner;

    @ManyToMany
    @JoinTable(
            name = "followed_playlists_by_user",
            joinColumns = {@JoinColumn(name = "playlist_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> usersWhoFollows = new ArrayList<User>();

/*
    @OneToMany
    private List<Song> songs=new ArrayList<Song>();

    @OneToMany(mappedBy ="playlistId")
    private List<PlaylistSong> songs;*/

    public Playlist(String type, Date createdDate, Date lastUpdateDate) {
        this.type = type;
        this.createdDate = createdDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public void addFollower(User user) {
        usersWhoFollows.add(user);
    }

    public void removeFollower(User user) {
        usersWhoFollows.remove(user);
    }


}
