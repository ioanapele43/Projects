package com.example.musify.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DynamicUpdate
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "country")
    private String country;

    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "owner", orphanRemoval = true)
    private List<Playlist> playlistsCreated;

    @ManyToMany(mappedBy = "usersWhoFollows")
    private List<Playlist> playlistsFollowed;

    public User(Integer id, String firstName, String lastName, String email, String password, String country, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.country = country;
        this.role = role;

    }


    public String composeFullName() {
        return firstName + " " + lastName;
    }

    public void addPlaylistCreated(Playlist playlist) {
        playlistsCreated.add(playlist);
    }

    public void removePlaylistCreated(Playlist playlist) {
        playlistsCreated.remove(playlist);
    }

    public void addFollowedPlaylist(Playlist playlist) {
        playlistsFollowed.add(playlist);
    }

}
