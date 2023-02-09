package com.example.socialapi.controller.authentication;

import com.example.socialapi.exception.SocialApiException;
import com.example.socialapi.model.AppUserDetails;
import com.example.socialapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public String signUpUser(@RequestBody RegistrationRequest registrationRequest){

        boolean emailExist = userRepository
                .findByUsername(registrationRequest.getEmail()).isPresent();
        boolean userNameExist = userRepository
                .findByUsername(registrationRequest.getUsername()).isPresent();

        if (emailExist){
            throw new SocialApiException(HttpStatus.BAD_REQUEST, "Username already taken");
        }
        if (userNameExist){
            throw new SocialApiException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        String firstname = registrationRequest.getFirstname().toLowerCase();
        String lastname = registrationRequest.getLastname().toLowerCase();
        String email = registrationRequest.getEmail().toLowerCase();
        String username = registrationRequest.getUsername().toLowerCase();
        String password = passwordEncoder.encode(registrationRequest.getPassword());

        AppUserDetails appUser = new AppUserDetails(firstname, lastname, email, username, password);

        userRepository.save(appUser);

        return "It works";
    }

    @PostMapping("/signin")
    public String signInUser(@RequestBody RegistrationRequest registrationRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registrationRequest.getUsername(),
                        registrationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "Signed in";
    }
}
