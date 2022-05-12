package com.example.musify.model;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class AlbumSongs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_number")
    private Integer orderNumber;

    @ManyToOne
    private Album album;

    @ManyToOne
    private Song song;


}
