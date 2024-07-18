package com.HuyEndy.webphimbackend.specification;

import com.HuyEndy.webphimbackend.model.Movie;
import org.springframework.data.jpa.domain.Specification;

public class MovieSpecification {
    public static Specification<Movie> hasSlug(String slug) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.or(
                        criteriaBuilder.like(root.get("slug"), "%" + slug + "%"),
                        criteriaBuilder.like(root.get("slugOriginName"), "%" + slug + "%")
                );
    }

    public static Specification<Movie> hasGenre(String genre) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.join("genres").get("name"), genre);
    }

    public static Specification<Movie> hasCountry(String country) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("country"), country);
    }

    public static Specification<Movie> hasCategory(String category) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.join("categories").get("name"), category);
    }

    public static Specification<Movie> hasYear(Integer year) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("year"), year);
    }
}
