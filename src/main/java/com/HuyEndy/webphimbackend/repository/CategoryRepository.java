package com.HuyEndy.webphimbackend.repository;

import com.HuyEndy.webphimbackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("SELECT c FROM Category c WHERE c.status = true")
    List<Category> getAllCategoryNotHidden();
}
