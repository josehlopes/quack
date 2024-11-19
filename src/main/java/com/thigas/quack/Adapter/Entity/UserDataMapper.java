package com.thigas.quack.Adapter.Entity;

import com.thigas.quack.Domain.Utils.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.time.OffsetDateTime;

/**
 * Entidade JPA que mapeia os dados do usuário para a tabela "app_user" no banco de dados.
 *
 * <p>Essa classe é usada como um **Data Mapper** no padrão de arquitetura Clean Architecture, conectando
 * a camada de persistência (banco de dados) com a aplicação. Ela contém os atributos necessários
 * para persistir as informações do usuário.</p>
 *
 * <p>A tabela correspondente é "app_user", e a chave primária é gerada automaticamente.</p>
 *
 * <p>Principais características:</p>
 * <ul>
 *   <li>Inclui anotações JPA para mapear os campos corretamente.</li>
 *   <li>Suporte a valores únicos para `cpf` e `username`.</li>
 *   <li>Validações básicas como campos não nulos e checks SQL para o status do usuário.</li>
 *   <li>Usa Lombok para reduzir boilerplate em getters, setters e métodos auxiliares.</li>
 * </ul>
 *
 * <p>Essa classe implementa métodos sobrescritos de `equals` e `hashCode` para lidar com proxies do Hibernate.</p>
 *
 * @see lombok.Getter
 * @see lombok.Setter
 * @see jakarta.persistence.Entity
 * @see jakarta.persistence.Table
 */
@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class UserDataMapper {

    /**
     * Identificador único do usuário.
     *
     * <p>É a chave primária da tabela "app_user". O valor é gerado automaticamente usando a estratégia
     * {@link GenerationType#IDENTITY}.</p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nome do usuário.
     *
     * <p>Esse campo é obrigatório e não pode ser nulo.</p>
     */
    @Column(nullable = false)
    private String name;

    /**
     * Sobrenome do usuário.
     *
     * <p>Esse campo é obrigatório e não pode ser nulo.</p>
     */
    @Column(nullable = false)
    private String surname;

    /**
     * Nome completo do usuário.
     *
     * <p>Esse campo é gerado e persistido como a concatenação do nome e sobrenome.</p>
     */
    @Column(nullable = false)
    private String fullName;

    /**
     * Nome de usuário único.
     *
     * <p>Deve ser único no banco de dados e não pode ser nulo. Representa o identificador público
     * do usuário no sistema.</p>
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * Número de telefone do usuário.
     *
     * <p>Esse campo é obrigatório e não pode ser nulo.</p>
     */
    @Column(nullable = false)
    private String phone;

    /**
     * E-mail do usuário.
     *
     * <p>Esse campo é obrigatório e não pode ser nulo.</p>
     */
    @Column(nullable = false)
    private String email;

    /**
     * Senha do usuário.
     *
     * <p>Esse campo é obrigatório e deve ser armazenado de forma segura (ex.: hash). Não pode ser nulo.</p>
     */
    @Column(nullable = false)
    private String password;

    /**
     * CPF único do usuário.
     *
     * <p>Deve ser único no banco de dados e não pode ser nulo. Representa o identificador fiscal
     * do usuário no Brasil.</p>
     */
    @Column(nullable = false, unique = true)
    private String cpf;

    /**
     * Data de nascimento do usuário.
     *
     * <p>É armazenado como um campo do tipo DATE no banco de dados e é obrigatório.</p>
     */
    @Column(name = "born_at", columnDefinition = "DATE", nullable = false)
    private LocalDate bornDate;

    /**
     * Data e hora de registro do usuário no sistema.
     *
     * <p>É armazenado como um campo do tipo TIMESTAMP com fuso horário no banco de dados.</p>
     */
    @Column(name = "register_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime registerOn;

    /**
     * Status de ativação do usuário.
     *
     * <p>É representado por um valor inteiro (0 ou 1) e validado com um check SQL no banco de dados.
     * O valor padrão é 1 (ativo).</p>
     */
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    /**
     * Caminho da imagem de perfil do usuário.
     *
     * <p>É opcional e pode armazenar um caminho para o arquivo de imagem no servidor.</p>
     */
    @Column(name = "image_path")
    private String imagePath;

    /**
     * Método sobrescrito para comparar objetos de forma segura, considerando proxies do Hibernate.
     *
     * @param o O objeto a ser comparado.
     * @return {@code true} se os objetos forem iguais, {@code false} caso contrário.
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        UserDataMapper userDataMapper = (UserDataMapper) o;
        return false;
    }

    /**
     * Método sobrescrito para calcular o hash code de forma segura, considerando proxies do Hibernate.
     *
     * @return O hash code da classe ou do proxy correspondente.
     */
    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
