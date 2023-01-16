package com.example.socialapi.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class AppUserDetails implements UserDetails {


    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
//    private AppUserRole appUserRole;

    private Collection<? extends GrantedAuthority> appUserRole;
    public AppUserDetails(String firstname, String lastname, String email,
                   String username, String password/*,
                   Collection<? extends GrantedAuthority> appUserRole*/) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;

        if (appUserRole == null){
            this.appUserRole = null;
        } else {
            this.appUserRole = new ArrayList<>(appUserRole);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
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
