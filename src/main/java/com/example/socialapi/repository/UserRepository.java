package com.example.socialapi.repository;

import com.example.socialapi.exceptions.ResourceNotFoundException;
import com.example.socialapi.model.AppUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUserDetails, Long> {

    Optional<AppUserDetails> findByUsername(String username);
    Optional<AppUserDetails> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<AppUserDetails> findByUsernameOrEmail(String username, String email);

    default AppUserDetails getUserByName(String username){
        return findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
    }

}
