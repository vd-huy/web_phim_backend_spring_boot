package com.HuyEndy.webphimbackend.service.movie;

import com.HuyEndy.webphimbackend.dto.MovieFilterDTO;
import com.HuyEndy.webphimbackend.model.Genre;
import com.HuyEndy.webphimbackend.model.Movie;
import com.HuyEndy.webphimbackend.repository.MovieRepository;
import com.HuyEndy.webphimbackend.specification.MovieSpecificationsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieSpecificationsBuilder specificationsBuilder;

    public Page<Movie> getAllMovies(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return movieRepository.findAll(pageable);
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie createOrUpdateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public Page<Movie> filterMovies(int page, int size, String sortBy, String direction,MovieFilterDTO movieFilter) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return movieRepository.findAll(specificationsBuilder.build(movieFilter), pageable);
    }

//    public List<Movie> searchMovieByName(String movieName) {
//        return movieRepository.searchMovieByName(movieName);
//    }

    public Page<Movie> searchMovieByName(int page, int size, String sortBy, String direction, String movieName) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return movieRepository.searchMovieByName(movieName, pageable);
    }
}
