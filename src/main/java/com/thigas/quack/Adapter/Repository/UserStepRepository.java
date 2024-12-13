package com.thigas.quack.Adapter.Repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import com.thigas.quack.Adapter.Entity.UserStepDataMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserStepRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserStepRepository.class);
    private final EntityManager entityManager;

    @Transactional
    public Boolean save(UserStepDataMapper userStep) {
        try {
            entityManager.persist(userStep);
            entityManager.flush();
            return true;
        } catch (Exception e) {
            logger.error("Erro ao salvar UserStep: {}", e.getMessage(), e);
            return false;
        }
    }

    @Transactional
    public void update(UserStepDataMapper userStep) {
        try {
            entityManager.merge(userStep);
        } catch (Exception e) {
            logger.error("Erro ao atualizar UserStep: {}", e.getMessage(), e);
        }
    }

    @Transactional(readOnly = true)
    public List<UserStepDataMapper> getUserStepsByUserId(Integer userId) {
        try {
            TypedQuery<UserStepDataMapper> query = entityManager.createQuery(
                    "SELECT u FROM UserStepDataMapper u WHERE u.user.id = :userId", UserStepDataMapper.class);
            query.setParameter("userId", userId);
            return query.getResultList();
        } catch (Exception e) {
            return List.of();
        }
    }

    @Transactional(readOnly = true)
    public Optional<UserStepDataMapper> getById(Integer id) {
        try {
            return Optional.ofNullable(entityManager.find(UserStepDataMapper.class, id));
        } catch (Exception e) {
            logger.error("Erro ao buscar UserStep por ID: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Integer id) {
        try {
            return entityManager.find(UserStepDataMapper.class, id) != null;
        } catch (Exception e) {
            logger.error("Erro ao verificar se UserStep existe por ID: {}", e.getMessage(), e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    public Optional<UserStepDataMapper> getUserStep(Integer userId, Integer stepId) {
        try {
            TypedQuery<UserStepDataMapper> query = entityManager.createQuery(
                    "SELECT a FROM UserStepDataMapper a WHERE a.user.id = :user_id AND a.step.id = :step_id", UserStepDataMapper.class);
            query.setParameter("user_id", userId);
            query.setParameter("step_id", stepId);
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            logger.error("Erro ao buscar UserStep por userId e stepId: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Iterable<UserStepDataMapper> getAllUserSteps() {
        try {
            TypedQuery<UserStepDataMapper> query = entityManager.createQuery(
                    "SELECT a FROM UserStepDataMapper a", UserStepDataMapper.class);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao buscar todos os UserSteps: {}", e.getMessage(), e);
        }
        return null;
    }

    @Transactional
    public void deleteById(Integer id) {
        try {
            UserStepDataMapper userStep = entityManager.find(UserStepDataMapper.class, id);
            if (userStep != null) {
                entityManager.remove(userStep);
            }
        } catch (Exception e) {
            logger.error("Erro ao excluir UserStep por ID: {}", e.getMessage(), e);
        }
    }
}
