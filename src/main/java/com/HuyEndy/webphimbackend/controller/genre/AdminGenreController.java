package com.HuyEndy.webphimbackend.controller.genre;

import com.HuyEndy.webphimbackend.model.Genre;
import com.HuyEndy.webphimbackend.service.genre.GenreService;
import com.HuyEndy.webphimbackend.service.slug.SlugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin/genre")
public class AdminGenreController {

    @Autowired
    private GenreService genreService;

    @Autowired
    private SlugService slugService;

    @GetMapping("/{id}")
    public Genre getGenreById(@RequestHeader("Authorization") String jwt, @PathVariable Long id) throws Exception {

        Optional<Genre> optional = genreService.getGenreById(id);

        if (optional.isEmpty() ){
            throw new Exception("Genre not found with id" + id);
        }

        return optional.get();
    }

    @PostMapping
    public Genre createGenre(@RequestHeader("Authorization") String jwt,@RequestBody Genre req) {

        Genre genre = new Genre();
        genre.setTitle(req.getTitle());
        genre.setDescription(req.getDescription());
        genre.setStatus(req.getStatus());
        genre.setSlug(slugService.toSlug(req.getTitle()));

        return genreService.createOrUpdateGenre(genre);
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@RequestHeader("Authorization") String jwt,@PathVariable Long id, @RequestBody Genre req) throws Exception {
        Optional<Genre> optional = genreService.getGenreById(id);

        if (optional.isEmpty() ){
            throw new Exception("Genre not found with id" + id);
        }

        Genre genre = optional.get();
        genre.setTitle(req.getTitle());
        genre.setDescription(req.getDescription());
        genre.setStatus(req.getStatus());
        genre.setSlug(slugService.toSlug(req.getTitle()));

        return genreService.createOrUpdateGenre(genre);
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@RequestHeader("Authorization") String jwt,@PathVariable Long id) {
        genreService.deleteGenre(id);
    }
}
