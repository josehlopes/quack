package com.thigas.quack.Domain.Factory;

import com.thigas.quack.Domain.Entity.CommonUser;
import com.thigas.quack.Domain.Entity.User;
import com.thigas.quack.Domain.Utils.UsernameGenerator;

import java.time.LocalDate;
import java.time.OffsetDateTime;

/**
 * Implementação da interface {@link UserFactory} para criar instâncias de {@link CommonUser}.
 *
 * <p>Essa classe encapsula a lógica de criação de usuários do tipo {@code CommonUser},
 * preenchendo automaticamente informações adicionais, como o nome de usuário,
 * status inicial, data de registro e nome completo.</p>
 *
 * <p>Segue o padrão de Fábrica para separar a lógica de construção de objetos
 * da lógica de uso, mantendo o código mais coeso e fácil de modificar.</p>
 *
 * @see UserFactory
 * @see CommonUser
 */
public class CommonUserFactory implements UserFactory {

    /**
     * Cria uma nova instância de {@link CommonUser}.
     *
     * <p>Os seguintes campos são gerados automaticamente:</p>
     * <ul>
     *   <li><strong>fullName</strong>: Concatenado com o nome e sobrenome fornecidos.</li>
     *   <li><strong>username</strong>: Gerado com base no nome e sobrenome usando {@link UsernameGenerator}.</li>
     *   <li><strong>registerOn</strong>: Atribuído com a data e hora atual ({@link OffsetDateTime#now()}).</li>
     *   <li><strong>isActive</strong>: Inicializado como {@code true}, indicando que o usuário está ativo.</li>
     * </ul>
     *
     * @param name      O nome do usuário.
     * @param surname   O sobrenome do usuário.
     * @param phone     O número de telefone do usuário.
     * @param email     O endereço de e-mail do usuário.
     * @param password  A senha do usuário.
     * @param cpf       O CPF do usuário.
     * @param bornAt    A data de nascimento do usuário.
     * @param imagePath O caminho para a imagem de perfil do usuário.
     * @return Uma instância de {@link CommonUser} preenchida com os dados fornecidos e gerados.
     */
    @Override
    public User create(String name, String surname, String phone, String email, String password,
                       String cpf, LocalDate bornAt, String imagePath) {
        // Gera a data de registro como o momento atual
        OffsetDateTime registerOn = OffsetDateTime.now();

        // Gera o nome completo concatenando nome e sobrenome
        String fullName = name + " " + surname;

        // Gera o nome de usuário com base no nome e sobrenome
        String username = UsernameGenerator.generateUsername(name, surname);

        // Retorna uma nova instância de CommonUser
        return new CommonUser(null, name, surname, fullName, username, phone, email, password, cpf, bornAt, registerOn, imagePath, true);
    }
}
