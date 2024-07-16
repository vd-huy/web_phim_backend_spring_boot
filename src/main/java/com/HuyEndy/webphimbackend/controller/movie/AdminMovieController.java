package com.HuyEndy.webphimbackend.controller.movie;

import com.HuyEndy.webphimbackend.dto.MovieDTO;
import com.HuyEndy.webphimbackend.model.Category;
import com.HuyEndy.webphimbackend.model.Country;
import com.HuyEndy.webphimbackend.model.Genre;
import com.HuyEndy.webphimbackend.model.Movie;
import com.HuyEndy.webphimbackend.repository.CategoryRepository;
import com.HuyEndy.webphimbackend.repository.CountryRepository;
import com.HuyEndy.webphimbackend.repository.GenreRepository;
import com.HuyEndy.webphimbackend.service.movie.MovieService;
import com.HuyEndy.webphimbackend.service.slug.SlugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin/movie")
public class AdminMovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private  SlugService slugService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private GenreRepository genreRepository;

    @PostMapping
    public Movie createMovie(@RequestHeader("Authorization") String jwt, @RequestBody MovieDTO req) {

        Movie movie = new Movie();
        movie.setTitle(req.getTitle());
        movie.setDescription(req.getDescription());
        movie.setStatus(req.getStatus());
        movie.setSlug(slugService.toSlug(req.getTitle()));
        movie.setImage(req.getImage());
        movie.setTime(req.getTime() + " phút/tập");
        movie.setYear(req.getYear());
        movie.setCreatedAt(LocalDate.now());
        movie.setUpdatedTime(LocalDate.now());

        // Set categories
        List<Category> categories = req.getCategoryIds().stream()
                .map(categoryRepository::findById)
                .map(optional -> optional.orElseThrow(() -> new RuntimeException("Category not found")))
                .collect(Collectors.toList());
        movie.setCategories(categories);

        // add movie into genres
        for (Category category : categories) {
            category.getMovies().add(movie);
        }

        // Set country
        Country country = countryRepository.findById(req.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));
        movie.setCountry(country);

        // add movie into genres
        country.getMovies().add(movie);

        // Set genres
        List<Genre> genres = req.getGenreIds().stream()
                .map(genreRepository::findById)
                .map(optional -> optional.orElseThrow(() -> new RuntimeException("Genre not found")))
                .collect(Collectors.toList());
        movie.setGenres(genres);

        // add movie into genres
        for (Genre genre : genres) {
            genre.getMovies().add(movie);
        }

        return movieService.createOrUpdateGenre(movie) ;
    }
}
