package com.HuyEndy.webphimbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private Boolean status;

    private String image;

    private int year;

    private String time;

    private String slug;

    private LocalDate createdAt;

    private LocalDate updatedTime;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Episode> episodes = new ArrayList<>();

    @ManyToOne
    private Country country;

    @ManyToMany
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "movie", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();





}
