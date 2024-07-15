package com.HuyEndy.webphimbackend.repository;

import com.HuyEndy.webphimbackend.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode,Long> {
}
