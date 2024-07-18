package com.HuyEndy.webphimbackend.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    private String title;
    private String description;
    private Boolean status;
    private String slug;
}
