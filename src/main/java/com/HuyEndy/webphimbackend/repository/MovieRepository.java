package com.HuyEndy.webphimbackend.repository;

import com.HuyEndy.webphimbackend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query("Select m From Movie m JOIN m.categories c WHERE c.slug = :categorySlug")
    List<Movie> searchMovieBySlugCategory(@Param("categorySlug") String categorySlug);

    @Query("Select m From Movie m JOIN m.country c WHERE c.slug = :countrySlug")
    List<Movie> searchMovieBySlugCountry(@Param("countrySlug") String countrySlug);

    @Query("Select m From Movie m JOIN m.genres g WHERE g.slug = :genreSlug")
    List<Movie> searchMovieBySlugGenre(@Param("genreSlug") String genreSlug);

    @Query("Select m From Movie m Where m.slug = :movieSlug")
    Movie findByMovieSlug(@Param("movieSlug") String movieSlug);


}
