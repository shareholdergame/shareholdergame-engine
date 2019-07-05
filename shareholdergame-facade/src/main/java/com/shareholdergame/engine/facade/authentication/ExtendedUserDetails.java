package com.shareholdergame.engine.facade.authentication;

import io.micronaut.security.authentication.UserDetails;

import java.util.Collection;

public class ExtendedUserDetails extends UserDetails {

    private Long id;

    public ExtendedUserDetails(String username, Collection<String> roles, Long id) {
        super(username, roles);
        this.id = id;
    }

    Long getId() {
        return id;
    }
}
