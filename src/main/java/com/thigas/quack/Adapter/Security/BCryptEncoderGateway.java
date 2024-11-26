package com.thigas.quack.Adapter.Security;

import com.thigas.quack.UseCase.Gateway.EncoderGateway;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
public class BCryptEncoderGateway implements EncoderGateway {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Boolean match(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }
}
