package com.HuyEndy.webphimbackend.controller.category;

import com.HuyEndy.webphimbackend.dto.ResponseDTO;
import com.HuyEndy.webphimbackend.model.Category;
import com.HuyEndy.webphimbackend.repository.CategoryRepository;
import com.HuyEndy.webphimbackend.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public Page<Category> getAllCategories(
                                            @RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,
                                           @RequestParam(defaultValue = "id") String sortBy,
                                           @RequestParam(defaultValue = "asc") String direction) {
        return categoryService.getAllCategories(page, size, sortBy, direction);
    }

    @GetMapping("/all")
    public List<ResponseDTO> getAll(){
        List<Category> categories = categoryRepository.getAllCategoryNotHidden();

        List<ResponseDTO> responseDTOList = new ArrayList<>();

        for (Category category : categories) {
            ResponseDTO responseDTO = new ResponseDTO();

            responseDTO.setId(category.getId());
            responseDTO.setTitle(category.getTitle());

            responseDTOList.add(responseDTO);
        }

        return  responseDTOList;
    }


}
