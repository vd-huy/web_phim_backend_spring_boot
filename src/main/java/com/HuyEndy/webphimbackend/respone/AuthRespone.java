package com.HuyEndy.webphimbackend.respone;

import com.HuyEndy.webphimbackend.model.USER_ROLE;
import lombok.Data;

@Data
public class AuthRespone {

    private String jwt;
    private String message;

    private USER_ROLE role;
}
