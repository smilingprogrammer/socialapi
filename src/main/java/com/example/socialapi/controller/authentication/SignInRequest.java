package com.example.socialapi.controller.authentication;

import lombok.Data;

@Data
public class SignInRequest {

    private String username;
    private String password;
}
