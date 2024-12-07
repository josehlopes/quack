package com.thigas.quack.UseCase.Gateway;

public interface EncoderGateway {
    Boolean matchPassword(String password, String encodedPassword);
}
