package com.HuyEndy.webphimbackend.dto;

import lombok.Data;

import java.time.LocalDate;


public class MovieUpdateDTO {
    private String title;

    private String originName;

    private String description;

    private Boolean status;

    private String image;

    private int year;

    private String time;


    private String slug;

    private String slugOriginName;

    private LocalDate updatedTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSlugOriginName() {
        return slugOriginName;
    }

    public void setSlugOriginName(String slugOriginName) {
        this.slugOriginName = slugOriginName;
    }

    public LocalDate getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDate updatedTime) {
        this.updatedTime = updatedTime;
    }
}
