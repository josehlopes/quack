package com.thigas.quack.Domain.Utils;

import java.util.Random;

public class UsernameGenerator {

    private static final Random random = new Random();

    public static String generateUsername(String name, String surname) {
        String baseUsername = (name + surname).toLowerCase();
        String username = baseUsername;
        int randomNumber = random.nextInt(1000);
        username += randomNumber;

        return username;
    }
}