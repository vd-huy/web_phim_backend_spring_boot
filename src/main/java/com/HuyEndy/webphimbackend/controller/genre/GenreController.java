package com.HuyEndy.webphimbackend.controller.genre;


import com.HuyEndy.webphimbackend.model.Genre;
import com.HuyEndy.webphimbackend.service.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @Autowired
    private GenreService genreService ;

    @GetMapping
    public Page<Genre> getAllGenres(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return genreService.getAllGenres(page, size, sortBy, direction);
    }
}
