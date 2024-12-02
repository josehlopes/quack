package com.thigas.quack.UseCase.Gateway;

import java.time.Instant;

public interface TokenGateway {
    String generateToken(String email);

    String validateToken(String token);

    Instant generateExpirationDate();
}
