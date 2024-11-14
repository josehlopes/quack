package com.thigas.quack.Infrastructure.Repository;

import com.thigas.quack.Infrastructure.Entity.UserDataMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(UserDataMapper user) {
        entityManager.persist(user);
    }

    @Transactional(readOnly = true)
    public Optional<UserDataMapper> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(UserDataMapper.class, id));
    }

    @Transactional(readOnly = true)
    public Optional<UserDataMapper> findByEmail(String email) {
        TypedQuery<UserDataMapper> query = entityManager.createQuery("SELECT u FROM UserDataMapper u WHERE u.email = :email", UserDataMapper.class);
        query.setParameter("email", email);
        return query.getResultStream().findFirst();
    }

    @Transactional(readOnly = true)
    public Optional<UserDataMapper> findByUsername(String username) {
        TypedQuery<UserDataMapper> query = entityManager.createQuery("SELECT u FROM UserDataMapper u WHERE u.username = :username", UserDataMapper.class);
        query.setParameter("username", username);
        return query.getResultStream().findFirst();
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Integer id) {
        return entityManager.find(UserDataMapper.class, id) != null;
    }

    @Transactional(readOnly = true)
    public Boolean existsByEmail(String email) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(u) FROM UserDataMapper u WHERE u.email = :email", Long.class);
        query.setParameter("email", email);
        return query.getSingleResult() > 0;
    }

    @Transactional(readOnly = true)
    public Boolean existsByUsername(String username) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(u) FROM UserDataMapper u WHERE u.username = :username", Long.class);
        query.setParameter("username", username);
        return query.getSingleResult() > 0;
    }

    @Transactional(readOnly = true)
    public Iterable<UserDataMapper> getAll() {
        TypedQuery<UserDataMapper> query = entityManager.createQuery("SELECT u FROM UserDataMapper u", UserDataMapper.class);
        return query.getResultList();
    }

    @Transactional
    public void deleteById(Integer id) {
        UserDataMapper user = entityManager.find(UserDataMapper.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}