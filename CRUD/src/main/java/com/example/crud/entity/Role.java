package com.example.crud.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN, EMPLOYER;

    @Override
    public String getAuthority() {
        return name();
    }
}
