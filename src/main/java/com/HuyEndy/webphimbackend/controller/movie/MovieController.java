package com.HuyEndy.webphimbackend.controller.movie;

import com.HuyEndy.webphimbackend.dto.MovieFilterDTO;
import com.HuyEndy.webphimbackend.model.Movie;
import com.HuyEndy.webphimbackend.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/search/{movieName}")
    public Page<Movie> searchMovie(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @PathVariable String movieName) {
        return movieService.searchMovieByName(page, size, sortBy, direction,movieName);
    }

    @GetMapping("/all")
    public Page<Movie> getAllMovie(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return movieService.getAllMovies(page, size, sortBy, direction);
    }

    @PostMapping("/filter")
    public Page<Movie> filterMovie (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestBody MovieFilterDTO movieFilter){
        return movieService.filterMovies(page,size,sortBy,direction,movieFilter);
    }


}
