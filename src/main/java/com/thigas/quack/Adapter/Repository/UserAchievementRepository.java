package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.AchievementDataMapper;
import com.thigas.quack.Adapter.Entity.UserAchievementDataMapper;
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
public class UserAchievementRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserAchievementRepository.class);
    private final EntityManager entityManager;

    @Transactional
    public void save(UserAchievementDataMapper achievement) {
        try {
            entityManager.persist(achievement);
        } catch (Exception e) {
            logger.error("Erro ao salvar achievement: {}", e.getMessage(), e);
        }
    }

    @Transactional
    public void update(UserAchievementDataMapper achievement) {
        try {
            entityManager.merge(achievement);
        } catch (Exception e) {
            logger.error("Erro ao atualizar achievement: {}", e.getMessage(), e);
        }
    }

    @Transactional(readOnly = true)
    public Optional<UserAchievementDataMapper> getById(Integer id) {
        try {
            return Optional.ofNullable(entityManager.find(UserAchievementDataMapper.class, id));
        } catch (Exception e) {
            logger.error("Erro ao buscar achievement por ID: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Integer id) {
        try {
            return entityManager.find(UserAchievementDataMapper.class, id) != null;
        } catch (Exception e) {
            logger.error("Erro ao verificar se achievement existe por ID: {}", e.getMessage(), e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    public Boolean existsByUserIdAndAchievementId(Integer userId, Integer achievementId) {
        try {
            TypedQuery<Long> query = entityManager.createQuery(
                    "SELECT COUNT(a) FROM UserAchievementDataMapper a WHERE a.user.id = :user_id AND a.achievement.id = :achievement_id", Long.class);
            query.setParameter("user_id", userId);
            query.setParameter("achievement_id", achievementId);
            return query.getSingleResult() > 0;
        } catch (Exception e) {
            logger.error("Erro ao verificar se achievement existe por userId e achievementId: {}", e.getMessage(), e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    public Optional<UserAchievementDataMapper> getUserAchievement(Integer userId, Integer achievementId) {
        try {
            TypedQuery<UserAchievementDataMapper> query = entityManager.createQuery(
                    "SELECT a FROM UserAchievementDataMapper a WHERE a.user.id = :user_id AND a.id = :achievement_id", UserAchievementDataMapper.class);
            query.setParameter("user_id", userId);
            query.setParameter("achievement_id", achievementId);
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            logger.error("Erro ao buscar achievement do usuário: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Iterable<AchievementDataMapper> getAllUserAchievements(Integer userId) {
        try {
            TypedQuery<AchievementDataMapper> query = entityManager.createQuery(
                    "SELECT a.achievement FROM UserAchievementDataMapper a WHERE a.user.id = :user_id", AchievementDataMapper.class);
            query.setParameter("user_id", userId);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao buscar achievements do usuário: {}", e.getMessage(), e);
        }
        return null;
    }

    @Transactional
    public void deleteById(Integer id) {
        try {
            UserAchievementDataMapper user = entityManager.find(UserAchievementDataMapper.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
        } catch (Exception e) {
            logger.error("Erro ao excluir achievement por ID: {}", e.getMessage(), e);
        }
    }

}
