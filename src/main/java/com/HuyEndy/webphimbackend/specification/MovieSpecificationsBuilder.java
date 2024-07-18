package com.HuyEndy.webphimbackend.specification;

import com.HuyEndy.webphimbackend.dto.MovieFilterDTO;
import com.HuyEndy.webphimbackend.model.Movie;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class MovieSpecificationsBuilder {

    public Specification<Movie> build(MovieFilterDTO movieFilter) {
        Specification<Movie> spec = Specification.where(null);

        if (movieFilter.getSlug() != null) {
            spec = spec.and(MovieSpecification.hasSlug(movieFilter.getSlug()));
        }
        if (movieFilter.getGenre() != null) {
            spec = spec.and(MovieSpecification.hasGenre(movieFilter.getGenre()));
        }
        if (movieFilter.getCountry() != null) {
            spec = spec.and(MovieSpecification.hasCountry(movieFilter.getCountry()));
        }
        if (movieFilter.getCategory() != null) {
            spec = spec.and(MovieSpecification.hasCategory(movieFilter.getCategory()));
        }
        if (movieFilter.getYear() != null) {
            spec = spec.and(MovieSpecification.hasYear(movieFilter.getYear()));
        }

        return spec;
    }
}
