package com.thigas.quack.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.thigas.quack.adapter.dto.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(UserDTO user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create().withIssuer("quack").withSubject(user.getEmail())
                    .withExpiresAt(this.generateExpirateDate()).sign(algorithm);
            System.out.println("Generated Token: " + token);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while authenticating");
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm).withIssuer("quack").build().verify(token).getSubject();
        } catch (JWTVerificationException exception) {
            System.out.println("Token Validation Error: " + exception.getMessage());
            throw new RuntimeException("Invalid or expired token");
        }
    }

    private Instant generateExpirateDate() {
        return LocalDateTime.now().plusHours(5).toInstant(ZoneOffset.of("-03:00"));
    }
}
