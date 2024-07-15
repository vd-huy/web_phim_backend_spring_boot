package com.HuyEndy.webphimbackend.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
