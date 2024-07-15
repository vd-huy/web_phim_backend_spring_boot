package com.HuyEndy.webphimbackend.repository;

import com.HuyEndy.webphimbackend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    public Comment findByMovieId(Long movieId);
}
