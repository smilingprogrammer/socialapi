package com.example.socialapi.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void signUpUser(@RequestBody RegistrationRequest registrationRequest){

        String firstname = registrationRequest.getFirstname().toLowerCase();
        String lastname = registrationRequest.getLastname().toLowerCase();
        String email = registrationRequest.getEmail().toLowerCase();
        String username = registrationRequest.getUsername().toLowerCase();
        String password = passwordEncoder.encode(registrationRequest.getPassword());

    }
}
