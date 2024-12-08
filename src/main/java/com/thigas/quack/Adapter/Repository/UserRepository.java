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

@Repository
@AllArgsConstructor
public class UserRepository {


    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    private final EntityManager entityManager;

    @Transactional
    public void save(UserDataMapper user) {
        try {
            entityManager.persist(user);
        } catch (Exception e) {
            logger.error("Erro ao salvar usuário: {}", e.getMessage(), e);
        }
    }

  
    @Transactional
    public void update(UserDataMapper user) {
        try {
            entityManager.merge(user);
        } catch (Exception e) {
            logger.error("Erro ao atualizar usuário: {}", e.getMessage(), e);
        }
    }

    
    @Transactional(readOnly = true)
    public Optional<UserDataMapper> findById(Integer id) {
        try {
            return Optional.ofNullable(entityManager.find(UserDataMapper.class, id));
        } catch (Exception e) {
            logger.error("Erro ao buscar usuário por ID: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

   
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

    
    @Transactional(readOnly = true)
    public Boolean existsById(Integer id) {
        try {
            return entityManager.find(UserDataMapper.class, id) != null;
        } catch (Exception e) {
            logger.error("Erro ao verificar se usuário existe por ID: {}", e.getMessage(), e);
        }
        return false;
    }

   
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
