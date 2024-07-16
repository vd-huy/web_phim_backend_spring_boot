package com.HuyEndy.webphimbackend.repository;

import com.HuyEndy.webphimbackend.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
}
