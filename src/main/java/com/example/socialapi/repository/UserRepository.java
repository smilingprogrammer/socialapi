package com.example.socialapi.repository;

import com.example.socialapi.exceptions.ResourceNotFoundException;
import com.example.socialapi.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);
//    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<AppUser> findByUsernameOrEmail(String username, String email);

    default AppUser getUserByName(String username){
        return findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
    }

}
