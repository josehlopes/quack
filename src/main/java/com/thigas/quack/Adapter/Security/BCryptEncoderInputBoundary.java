package com.thigas.quack.Adapter.Security;

import com.thigas.quack.UseCase.Boundary.EncoderInputBoundary;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
public class BCryptEncoderInputBoundary implements EncoderInputBoundary {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
