package com.thigas.quack.Domain.Utils;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

/**
 * Classe utilitária para geração de nomes de usuário.
 */
public class UsernameGenerator {

    private static final Random random = new Random();
    private static final int USERNAME_SUFFIX_BOUND = 9999;
    private static final int USERNAME_SUFFIX_OFFSET = 1;
    private static final Set<String> existingUsernames = new HashSet<>();

    /**
     * Gera um nome de usuário baseado no nome e sobrenome fornecidos.
     * O nome de usuário gerado é uma combinação de partes do nome e sobrenome em minúsculas,
     * seguido por um número aleatório de 1000 a 9999.
     * Espaços são substituídos por _.
     *
     * @param name    O nome do usuário.
     * @param surname O sobrenome do usuário.
     * @return O nome de usuário gerado.
     * @throws IllegalArgumentException se o nome ou sobrenome forem nulos ou vazios.
     */
    public static String generateUsername(String name, String surname) {
        if (name == null || name.isEmpty() || surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("First and last names cannot be null or void.");
        }

        String username;
        do {
            username = (name.substring(0, Math.min(3, name.length())) +
                    surname.substring(0, Math.min(3, surname.length()))).toLowerCase().replace(" ", "_");
            int randomNumber = random.nextInt(USERNAME_SUFFIX_BOUND) + USERNAME_SUFFIX_OFFSET;
            username += randomNumber;
        } while (existingUsernames.contains(username));

        existingUsernames.add(username);
        return username;
    }

    /**
     * Verifica se o nome de usuário já existe.
     *
     * @param username O nome de usuário a ser verificado.
     * @return true se o nome de usuário já existir, false caso contrário.
     */
    public static boolean usernameExists(String username) {
        return existingUsernames.contains(username);
    }
}