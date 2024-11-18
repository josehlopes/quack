package com.thigas.quack.Domain.Entity;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;

/**
 * Implementação concreta da interface {@link User}.
 *
 * <p>Representa um usuário comum no domínio da aplicação, encapsulando
 * informações pessoais e funcionalidades básicas.</p>
 *
 * <p>A classe utiliza anotações do Lombok para reduzir o boilerplate
 * de código, como getters, setters e construtores.</p>
 *
 * <ul>
 *   <li>{@link Data}: Gera automaticamente métodos como {@code equals}, {@code hashCode},
 *       {@code toString}, getters e setters.</li>
 *   <li>{@link NoArgsConstructor}: Cria um construtor sem argumentos.</li>
 *   <li>{@link AllArgsConstructor}: Cria um construtor que aceita todos os campos como argumentos.</li>
 * </ul>
 *
 * <p>Inclui validação de senha através do método {@link #passwordIsValid()}.</p>
 *
 * @see User
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonUser implements User {

    /**
     * Identificador único do usuário.
     */
    private Integer id;

    /**
     * Nome do usuário.
     */
    private String name;

    /**
     * Sobrenome do usuário.
     */
    private String surname;

    /**
     * Nome completo do usuário, composto pelo nome e sobrenome.
     */
    private String fullName;

    /**
     * Nome de usuário utilizado para login.
     */
    private String username;

    /**
     * Número de telefone do usuário.
     */
    private String phone;

    /**
     * Endereço de e-mail do usuário.
     */
    private String email;

    /**
     * Senha do usuário.
     * <p>Dependendo do contexto, a senha pode estar criptografada.</p>
     */
    private String password;

    /**
     * CPF do usuário.
     */
    private String cpf;

    /**
     * Data de nascimento do usuário.
     */
    private LocalDate bornDate;

    /**
     * Data e hora em que o usuário foi registrado no sistema.
     */
    private OffsetDateTime registerOn;

    /**
     * Caminho para a imagem de perfil do usuário.
     */
    private String imagePath;

    /**
     * Indica se o usuário está habilitado (ativo).
     * <p>Representa o status de ativação do usuário, podendo ser:</p>
     * <ul>
     *     <li><strong>1</strong>: O usuário está habilitado (ativo).</li>
     *     <li><strong>0</strong>: O usuário está desabilitado (inativo ou suspenso).</li>
     * </ul>
     */
    private Integer isActive = 1;


    /**
     * Valida se a senha do usuário atende aos requisitos mínimos de segurança.
     *
     * <p>A senha é considerada válida se atender aos seguintes critérios:</p>
     * <ul>
     *   <li>Não é nula.</li>
     *   <li>Possui pelo menos 8 caracteres.</li>
     *   <li>Contém pelo menos uma letra maiúscula.</li>
     *   <li>Contém pelo menos um caractere especial (como {@code !, @, #, $, %, ^}).</li>
     * </ul>
     *
     * @return {@code true} se a senha for válida, {@code false} caso contrário.
     */
    @Override
    public Boolean passwordIsValid() {
        return password != null && password.length() >= 8 &&
                password.matches(".*[A-Z].*") && password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}
