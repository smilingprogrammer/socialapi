package com.example.socialapi.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AppUserDetails implements UserDetails {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;

    private Collection<? extends GrantedAuthority> appUserRole;
    public AppUserDetails(String firstname, String lastname, String email,
                   String username, String password,
                   Collection<? extends GrantedAuthority> appUserRole) {
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

    public static AppUserDetails create(AppUser user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

        return new AppUserDetails(user.getFirstname(), user.getLastname(), user.getUsername(),
                user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
