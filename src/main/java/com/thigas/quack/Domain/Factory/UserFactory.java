package com.thigas.quack.Domain.Factory;

import com.thigas.quack.Domain.Entity.User;

import java.time.LocalDate;

/**
 * Fábrica para criação de instâncias da entidade {@link User}.
 *
 * <p>A interface define um contrato para criar objetos do tipo {@code User},
 * garantindo que a lógica de criação seja centralizada e padronizada.</p>
 *
 * <p>Usar um padrão de fábrica é útil para separar a lógica de construção
 * da lógica de uso, especialmente em contextos onde o processo de criação
 * pode variar dependendo de regras de negócio ou implementação específica.</p>
 *
 * @see User
 */
public interface UserFactory {

    /**
     * Cria uma nova instância de {@link User}.
     *
     * @param name      O nome do usuário.
     * @param surname   O sobrenome do usuário.
     * @param phone     O número de telefone do usuário.
     * @param email     O endereço de e-mail do usuário.
     * @param password  A senha do usuário.
     * @param cpf       O CPF do usuário.
     * @param bornAt    A data de nascimento do usuário.
     * @param imagePath O caminho para a imagem de perfil do usuário.
     * @return Uma instância de {@link User}.
     */
    User create(String name, String surname, String phone, String email, String password, String cpf, LocalDate bornAt, String imagePath);
}
