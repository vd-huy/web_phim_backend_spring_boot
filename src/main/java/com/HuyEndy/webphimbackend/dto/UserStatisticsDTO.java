package com.HuyEndy.webphimbackend.dto;

import java.time.LocalDate;

public class UserStatisticsDTO {

    private LocalDate date;
    private Long userCount;

    public UserStatisticsDTO(LocalDate date, Long userCount) {
        this.date = date;
        this.userCount = userCount;
    }

    public UserStatisticsDTO() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getUserCount() {
        return userCount;
    }

    public void setUserCount(Long userCount) {
        this.userCount = userCount;
    }
}
