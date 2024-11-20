package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.UserDataMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Repositório responsável por gerenciar as operações de persistência relacionadas à entidade {@link UserDataMapper}.
 *
 * <p>Essa classe utiliza o {@link EntityManager} do JPA para realizar operações no banco de dados, como
 * salvar, atualizar, buscar e excluir registros de usuários. Além disso, inclui tratamento de erros
 * e registro de logs utilizando {@link Logger} e {@link LoggerFactory}.</p>
 *
 * <p>Os métodos desta classe são anotados com {@link Transactional} para garantir que as operações sejam
 * executadas dentro de transações apropriadas.</p>
 *
 * @see UserDataMapper
 */
@Repository
@AllArgsConstructor
public class UserRepository {

    /**
     * Logger usado para registrar mensagens de erro ou informações importantes durante a execução dos métodos.
     */
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    /**
     * Gerenciador de entidades do JPA usado para realizar as operações de persistência.
     */
    private final EntityManager entityManager;

    /**
     * Salva um novo usuário no banco de dados.
     *
     * @param user A entidade {@link UserDataMapper} que representa o usuário a ser salvo.
     */
    @Transactional
    public void save(UserDataMapper user) {
        try {
            entityManager.persist(user);
        } catch (Exception e) {
            logger.error("Erro ao salvar usuário: {}", e.getMessage(), e);
        }
    }

    /**
     * Atualiza os dados de um usuário existente no banco de dados.
     *
     * @param user A entidade {@link UserDataMapper} com as informações atualizadas do usuário.
     */
    @Transactional
    public void update(UserDataMapper user) {
        try {
            entityManager.merge(user);
        } catch (Exception e) {
            logger.error("Erro ao atualizar usuário: {}", e.getMessage(), e);
        }
    }

    /**
     * Busca um usuário pelo seu ID.
     *
     * @param id O ID do usuário a ser buscado.
     * @return Um {@link Optional} contendo a entidade {@link UserDataMapper}, caso encontrado.
     * Caso ocorra algum erro, retorna um {@link Optional#empty()}.
     */
    @Transactional(readOnly = true)
    public Optional<UserDataMapper> findById(Integer id) {
        try {
            return Optional.ofNullable(entityManager.find(UserDataMapper.class, id));
        } catch (Exception e) {
            logger.error("Erro ao buscar usuário por ID: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    /**
     * Busca um usuário pelo seu e-mail.
     *
     * @param email O e-mail do usuário a ser buscado.
     * @return Um {@link Optional} contendo a entidade {@link UserDataMapper}, caso encontrado.
     * Caso ocorra algum erro, retorna um {@link Optional#empty()}.
     */
    @Transactional(readOnly = true)
    public Optional<UserDataMapper> findByEmail(String email) {
        try {
            TypedQuery<UserDataMapper> query = entityManager.createQuery(
                    "SELECT u FROM UserDataMapper u WHERE u.email = :email", UserDataMapper.class);
            query.setParameter("email", email);
            return query.getResultStream().findFirst();
        } catch (Exception e) {
            logger.error("Erro ao buscar usuário por e-mail: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    /**
     * Busca um usuário pelo seu nome de usuário (username).
     *
     * @param username O nome de usuário a ser buscado.
     * @return Um {@link Optional} contendo a entidade {@link UserDataMapper}, caso encontrado.
     * Caso ocorra algum erro, retorna um {@link Optional#empty()}.
     */
    @Transactional(readOnly = true)
    public Optional<UserDataMapper> findByUsername(String username) {
        try {
            TypedQuery<UserDataMapper> query = entityManager.createQuery(
                    "SELECT u FROM UserDataMapper u WHERE u.username = :username", UserDataMapper.class);
            query.setParameter("username", username);
            return query.getResultStream().findFirst();
        } catch (Exception e) {
            logger.error("Erro ao buscar usuário por nome de usuário: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    /**
     * Verifica se existe um usuário com o ID fornecido.
     *
     * @param id O ID do usuário.
     * @return {@code true} se o usuário existir, {@code false} caso contrário.
     * Retorna {@code false} em caso de erro.
     */
    @Transactional(readOnly = true)
    public Boolean existsById(Integer id) {
        try {
            return entityManager.find(UserDataMapper.class, id) != null;
        } catch (Exception e) {
            logger.error("Erro ao verificar se usuário existe por ID: {}", e.getMessage(), e);
        }
        return false;
    }

    /**
     * Verifica se existe um usuário com o e-mail fornecido.
     *
     * @param email O e-mail do usuário.
     * @return {@code true} se o usuário existir, {@code false} caso contrário.
     * Retorna {@code false} em caso de erro.
     */
    @Transactional(readOnly = true)
    public Boolean existsByEmail(String email) {
        try {
            TypedQuery<Long> query = entityManager.createQuery(
                    "SELECT COUNT(u) FROM UserDataMapper u WHERE u.email = :email", Long.class);
            query.setParameter("email", email);
            return query.getSingleResult() > 0;
        } catch (Exception e) {
            logger.error("Erro ao verificar se usuário existe por e-mail: {}", e.getMessage(), e);
        }
        return false;
    }

    /**
     * Verifica se existe um usuário com o nome de usuário fornecido.
     *
     * @param username O nome de usuário.
     * @return {@code true} se o usuário existir, {@code false} caso contrário.
     * Retorna {@code false} em caso de erro.
     */
    @Transactional(readOnly = true)
    public Boolean existsByUsername(String username) {
        try {
            TypedQuery<Long> query = entityManager.createQuery(
                    "SELECT COUNT(u) FROM UserDataMapper u WHERE u.username = :username", Long.class);
            query.setParameter("username", username);
            return query.getSingleResult() > 0;
        } catch (Exception e) {
            logger.error("Erro ao verificar se usuário existe por nome de usuário: {}", e.getMessage(), e);
        }
        return false;
    }

    /**
     * Retorna todos os usuários do banco de dados.
     *
     * @return Uma lista iterável contendo todas as entidades {@link UserDataMapper}.
     * Retorna {@code null} em caso de erro.
     */
    @Transactional(readOnly = true)
    public Iterable<UserDataMapper> getAll() {
        try {
            TypedQuery<UserDataMapper> query = entityManager.createQuery(
                    "SELECT u FROM UserDataMapper u", UserDataMapper.class);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao buscar todos os usuários: {}", e.getMessage(), e);
        }
        return null;
    }

    /**
     * Exclui um usuário do banco de dados com base no seu ID.
     *
     * @param id O ID do usuário a ser excluído.
     */
    @Transactional
    public void deleteById(Integer id) {
        try {
            UserDataMapper user = entityManager.find(UserDataMapper.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
        } catch (Exception e) {
            logger.error("Erro ao excluir usuário por ID: {}", e.getMessage(), e);
        }
    }
}
