package com.descubre.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class JWTUtil {
    @Value("${auth.token}")
    private static String authToken;

    public static final long EXPIRATION_TIME = Long.parseLong(System.getenv().getOrDefault("JWT_EXPIRATION_TIME", "86400000"));

    static {
        if (authToken == null || authToken.isEmpty()) {
            throw new IllegalArgumentException("The JWT secret key is not configured correctly.");
        }
    }

    public static String generateToken(String email, Set<String> roles) {
        return JWT.create()
                .withSubject(email)
                .withClaim("roles", roles.stream().collect(Collectors.toList()))
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(authToken));
    }

    public static DecodedJWT validateToken(String token) throws JWTVerificationException {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(authToken))
                    .build();
            return verifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new JWTVerificationException("Invalid ou expired token.");
        }
    }

    public static String getEmailFromToken(String token) {
        return validateToken(token).getSubject();
    }

    public static Set<String> getRolesFromToken(String token) {
        return Set.copyOf(validateToken(token).getClaim("roles").asList(String.class));
    }
}
