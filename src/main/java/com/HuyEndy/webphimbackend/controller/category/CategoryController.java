package com.HuyEndy.webphimbackend.controller.category;

import com.HuyEndy.webphimbackend.model.Category;
import com.HuyEndy.webphimbackend.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Page<Category> getAllCategories(
                                            @RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,
                                           @RequestParam(defaultValue = "id") String sortBy,
                                           @RequestParam(defaultValue = "asc") String direction) {
        return categoryService.getAllCategories(page, size, sortBy, direction);
    }


}
