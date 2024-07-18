package com.HuyEndy.webphimbackend.repository;

import com.HuyEndy.webphimbackend.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long>, JpaSpecificationExecutor<Movie> {

    @Query("Select m From Movie m JOIN m.categories c WHERE c.slug = :categorySlug")
    List<Movie> searchMovieBySlugCategory(@Param("categorySlug") String categorySlug);

    @Query("Select m From Movie m JOIN m.countries c WHERE c.slug = :countrySlug")
    List<Movie> searchMovieBySlugCountry(@Param("countrySlug") String countrySlug);

    @Query("Select m From Movie m JOIN m.genres g WHERE g.slug = :genreSlug")
    List<Movie> searchMovieBySlugGenre(@Param("genreSlug") String genreSlug);

    @Query("Select m From Movie m Where m.slug = :movieSlug")
    Movie findByMovieSlug(@Param("movieSlug") String movieSlug);

    @Query("SELECT m FROM Movie m WHERE m.slug LIKE %:movieName% OR m.slugOriginName LIKE %:movieName%  ")
    Page<Movie> searchMovieByName(@Param("movieName") String movieName, Pageable pageable);




}
