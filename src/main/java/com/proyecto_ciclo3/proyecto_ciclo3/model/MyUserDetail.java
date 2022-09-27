package com.proyecto_ciclo3.proyecto_ciclo3.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetail implements UserDetails {

    private String email;
    private String password;
//    private List<GrantedAuthority> authorities;

    public MyUserDetail(Employee user) {

        this.email = user.getEmail();
        this.password = user.getPassword();

//        List<GrantedAuthority> roles = new ArrayList<>();
//        for(Enum_RoleName rol : user.getRoles()){
//            roles.add(
//                    new SimpleGrantedAuthority(rol.name())
//            );
//        }
//
//        this.authorities = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
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
