package com.example.musify.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "alternative_titles")
public class AlternativeTitles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "alternative_title")
    private String alternativeTitle;
    @ManyToOne
    private Song song;

}
