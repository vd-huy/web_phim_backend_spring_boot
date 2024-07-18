package com.HuyEndy.webphimbackend.repository;

import com.HuyEndy.webphimbackend.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre,Long> {

    @Query("SELECT c FROM Genre c WHERE c.status = true")
    List<Genre> getAllGenreNotHidden();
}
