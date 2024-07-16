package com.HuyEndy.webphimbackend.controller.category;

import com.HuyEndy.webphimbackend.model.Category;
import com.HuyEndy.webphimbackend.service.category.CategoryService;
import com.HuyEndy.webphimbackend.service.slug.SlugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin/category")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SlugService slugService;

    @GetMapping("/{id}")
    public Category getCategoryById(@RequestHeader("Authorization") String jwt,@PathVariable Long id) throws Exception {

        Optional<Category> optional = categoryService.getCategoryById(id);

        if (optional.isEmpty() ){
            throw new Exception("Category not found with id" + id);
        }

        return optional.get();
    }

    @PostMapping
    public Category createCategory(@RequestHeader("Authorization") String jwt,@RequestBody Category req) {

        Category category = new Category();
        category.setTitle(req.getTitle());
        category.setDescription(req.getDescription());
        category.setStatus(req.getStatus());
        category.setSlug(slugService.toSlug(req.getTitle()));

        return categoryService.createOrUpdateCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@RequestHeader("Authorization") String jwt,@PathVariable Long id, @RequestBody Category req) throws Exception {
        Optional<Category> optional = categoryService.getCategoryById(id);

        if (optional.isEmpty() ){
            throw new Exception("Category not found with id" + id);
        }

        Category category = optional.get();
        category.setTitle(req.getTitle());
        category.setDescription(req.getDescription());
        category.setStatus(req.getStatus());
        category.setSlug(slugService.toSlug(req.getTitle()));

        return categoryService.createOrUpdateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@RequestHeader("Authorization") String jwt,@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

}
