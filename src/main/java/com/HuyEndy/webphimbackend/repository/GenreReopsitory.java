package com.HuyEndy.webphimbackend.repository;

import com.HuyEndy.webphimbackend.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreReopsitory extends JpaRepository<Genre,Long> {
}
