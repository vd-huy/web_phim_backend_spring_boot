package com.HuyEndy.webphimbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class UserRegistrationCountByMonthDTO {

    private int month; // Use int for month
    private long count; // Use long for count

    // Public constructor
    public UserRegistrationCountByMonthDTO(int month, long count) {
        this.month = month;
        this.count = count;
    }

    // Getters and Setters
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
