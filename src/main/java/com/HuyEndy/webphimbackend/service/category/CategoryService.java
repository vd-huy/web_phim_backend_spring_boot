package com.HuyEndy.webphimbackend.service.category;

import com.HuyEndy.webphimbackend.model.Category;
import com.HuyEndy.webphimbackend.repository.CategoryRepository;
import com.HuyEndy.webphimbackend.respone.MessageRespone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category createOrUpdateCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
