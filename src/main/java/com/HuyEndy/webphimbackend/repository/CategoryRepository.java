package com.HuyEndy.webphimbackend.repository;

import com.HuyEndy.webphimbackend.model.Category;
import com.HuyEndy.webphimbackend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
