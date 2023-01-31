package com.example.socialapi.authentication;

import com.example.socialapi.exception.SocialApiException;
import com.example.socialapi.model.AppUser;
import com.example.socialapi.repository.UserRepository;
import com.example.socialapi.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signUpUser(@RequestBody RegistrationRequest registrationRequest){

        if (Boolean.TRUE.equals(userRepository.existsByUsername(registrationRequest.getUsername()))){
            throw new SocialApiException(HttpStatus.BAD_REQUEST, "");
        }

        String firstname = registrationRequest.getFirstname().toLowerCase();
        String lastname = registrationRequest.getLastname().toLowerCase();
        String email = registrationRequest.getEmail().toLowerCase();
        String username = registrationRequest.getUsername().toLowerCase();
        String password = passwordEncoder.encode(registrationRequest.getPassword());

        AppUser appUser = new AppUser(firstname, lastname, email, username, password);

        AppUser result = userRepository.save(appUser);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{userId}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Registration Successful"));
    }
}
