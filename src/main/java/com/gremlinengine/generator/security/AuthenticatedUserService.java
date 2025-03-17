package com.gremlinengine.generator.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatedUserService {

    public String getUserId() {
        return getJwt().getSubject(); // Keycloak User ID (UUID)
    }

    public String getFirstName() {
        return getJwt().getClaim("given_name");
    }

    public String getLastName() {
        return getJwt().getClaim("family_name");
    }

    public String getEmail() {
        return getJwt().getClaim("email");
    }

    public String getUsername() {
        return getJwt().getClaim("preferred_username");
    }

    public boolean hasRole(String role) {
        return getJwt().getClaimAsStringList("realm_access.roles").contains(role);
    }

    private Jwt getJwt() {
        return ((JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication()).getToken();
    }
}
