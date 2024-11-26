package com.thigas.quack.UseCase.Gateway;

public interface EncoderGateway {
    Boolean match(String password, String encodedPassword);
}
