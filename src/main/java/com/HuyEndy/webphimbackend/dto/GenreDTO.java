package com.HuyEndy.webphimbackend.dto;

import lombok.Data;

@Data
public class GenreDTO {
    private Long id;
    private String title;
    private String description;
    private Boolean status;
    private String slug;
}
