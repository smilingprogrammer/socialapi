package com.example.socialapi.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails {

    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
//    private AppUserRole appUserRole;

//    private Collection<? extends GrantedAuthority> appUserRole;
    public AppUser(String firstname, String lastname, String email,
                   String username, String password/*,
                   Collection<? extends GrantedAuthority> appUserRole*/) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;

//        if (appUserRole == null){
//            this.appUserRole = null;
//        } else {
//            this.appUserRole = new ArrayList<>(appUserRole);
//        }
    }



    public String getFirstName(){
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
