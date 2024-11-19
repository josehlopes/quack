package com.thigas.quack.Domain.Entity;

import com.thigas.quack.Domain.Utils.Status;
import java.time.LocalDate;
import java.time.OffsetDateTime;

/**
 * Representa um usuário no domínio da aplicação.
 *
 * <p>Esta interface define os comportamentos e propriedades essenciais
 * de um usuário, independente da implementação específica.</p>
 *
 * <p>Responsável por encapsular informações básicas do usuário, como
 * dados pessoais e status, sendo parte fundamental da camada de domínio
 * em uma arquitetura limpa.</p>
 *
 * <p>Observação: Implementações desta interface devem garantir as regras
 * de negócio associadas aos métodos e atributos.</p>
 */
public interface User {

    /**
     * Obtém o identificador único do usuário.
     *
     * @return o ID do usuário como {@code Integer}.
     */
    Integer getId();

    /**
     * Obtém o nome do usuário.
     *
     * @return o nome do usuário como {@code String}.
     */
    String getName();

    /**
     * Obtém o sobrenome do usuário.
     *
     * @return o sobrenome do usuário como {@code String}.
     */
    String getSurname();

    /**
     * Obtém o nome completo do usuário, composto pelo nome e sobrenome.
     *
     * @return o nome completo do usuário como {@code String}.
     */
    String getFullName();

    /**
     * Obtém o nome de usuário utilizado para login.
     *
     * @return o nome de usuário como {@code String}.
     */
    String getUsername();

    /**
     * Obtém o telefone do usuário.
     *
     * @return o telefone do usuário como {@code String}.
     */
    String getPhone();

    /**
     * Obtém o e-mail do usuário.
     *
     * @return o e-mail do usuário como {@code String}.
     */
    String getEmail();

    /**
     * Obtém a senha do usuário.
     *
     * <p>A senha pode estar criptografada dependendo da implementação.</p>
     *
     * @return a senha do usuário como {@code String}.
     */
    String getPassword();

    /**
     * Obtém o CPF do usuário.
     *
     * @return o CPF do usuário como {@code String}.
     */
    String getCpf();

    /**
     * Obtém a data de nascimento do usuário.
     *
     * @return a data de nascimento como {@code LocalDate}.
     */
    LocalDate getBornDate();

    /**
     * Obtém a data de registro do usuário no sistema.
     *
     * @return a data e hora do registro como {@code OffsetDateTime}.
     */
    OffsetDateTime getRegisterOn();

    /**
     * Obtém o caminho da imagem do perfil do usuário.
     *
     * @return o caminho da imagem como {@code String}.
     */
    String getImagePath();

    /**
     * Verifica se o usuário está habilitado (ativo).
     *
     * @return {@code true} se o usuário estiver habilitado (ativo), {@code false} caso contrário.
     */
    Boolean getIsActive();


    /**
     * Verifica se a senha do usuário é válida.
     *
     * <p>Este método pode envolver validações específicas,
     * como força da senha ou conformidade com regras de segurança.</p>
     *
     * @return {@code true} se a senha for válida, {@code false} caso contrário.
     */
    Boolean passwordIsValid();
}
