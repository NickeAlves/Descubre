package com.descubre.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JWTUtil {

    @Value("${auth.token}")
    private String authToken;

    public static final long EXPIRATION_TIME = Long.parseLong(System.getenv().getOrDefault("JWT_EXPIRATION_TIME", "86400000"));

    public String generateToken(String email, Set<String> roles) {
        return JWT.create()
                .withSubject(email)
                .withClaim("roles", roles.stream().collect(Collectors.toList()))
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(authToken));
    }

    public DecodedJWT validateToken(String token) throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(authToken))
                .build();
        return verifier.verify(token);
    }

    public String getEmailFromToken(String token) {
        return validateToken(token).getSubject();
    }

    public Set<String> getRolesFromToken(String token) {
        return Set.copyOf(validateToken(token).getClaim("roles").asList(String.class));
    }
}
