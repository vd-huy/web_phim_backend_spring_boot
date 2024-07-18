package com.HuyEndy.webphimbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDTO {

    private String fullName;

    private String password;

    private String email;
}
