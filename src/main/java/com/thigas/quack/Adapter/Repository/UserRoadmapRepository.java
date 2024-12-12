package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.RoadmapDataMapper;
import com.thigas.quack.Adapter.Entity.UserRoadmapDataMapper;
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
public class UserRoadmapRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRoadmapRepository.class);
    private final EntityManager entityManager;

    @Transactional
    public Boolean save(UserRoadmapDataMapper userRoadmap) {
        try {
            entityManager.persist(userRoadmap);
            return true;
        } catch (Exception e) {
            logger.error("Erro ao salvar roadmap: {}", e.getMessage(), e);
            return false;
        }
    }

    @Transactional
    public void update(UserRoadmapDataMapper roadmap) {
        try {
            entityManager.merge(roadmap);
        } catch (Exception e) {
            logger.error("Erro ao atualizar roadmap: {}", e.getMessage(), e);
        }
    }

    @Transactional(readOnly = true)
    public Optional<UserRoadmapDataMapper> getById(Integer id) {
        try {
            return Optional.ofNullable(entityManager.find(UserRoadmapDataMapper.class, id));
        } catch (Exception e) {
            logger.error("Erro ao buscar roadmap por ID: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Integer id) {
        try {
            return entityManager.find(UserRoadmapDataMapper.class, id) != null;
        } catch (Exception e) {
            logger.error("Erro ao verificar se roadmap existe por ID: {}", e.getMessage(), e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    public Boolean existsByUserIdAndRoadmapId(Integer userId, Integer roadmapId) {
        try {
            TypedQuery<Long> query = entityManager.createQuery(
                    "SELECT COUNT(a) FROM UserRoadmapDataMapper a WHERE a.user.id = :user_id AND a.roadmap.id = :roadmap_id", Long.class);
            query.setParameter("user_id", userId);
            query.setParameter("roadmap_id", roadmapId);
            return query.getSingleResult() > 0;
        } catch (Exception e) {
            logger.error("Erro ao verificar se roadmap existe por userId e roadmapId: {}", e.getMessage(), e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    public Optional<UserRoadmapDataMapper> getUserRoadmap(Integer userId, Integer roadmapId) {
        try {
            TypedQuery<UserRoadmapDataMapper> query = entityManager.createQuery(
                    "SELECT a FROM UserRoadmapDataMapper a WHERE a.user.id = :user_id AND a.id = :roadmap_id", UserRoadmapDataMapper.class);
            query.setParameter("user_id", userId);
            query.setParameter("roadmap_id", roadmapId);
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            logger.error("Erro ao buscar roadmap do usuário: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Iterable<RoadmapDataMapper> getAllUserRoadmaps(Integer userId) {
        try {
            TypedQuery<RoadmapDataMapper> query = entityManager.createQuery(
                    "SELECT a.roadmap FROM UserRoadmapDataMapper a WHERE a.user.id = :user_id", RoadmapDataMapper.class);
            query.setParameter("user_id", userId);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao buscar roadmaps do usuário: {}", e.getMessage(), e);
        }
        return null;
    }

    @Transactional
    public void deleteById(Integer id) {
        try {
            UserRoadmapDataMapper userRoadmap = entityManager.find(UserRoadmapDataMapper.class, id);
            if (userRoadmap != null) {
                entityManager.remove(userRoadmap);
            }
        } catch (Exception e) {
            logger.error("Erro ao excluir roadmap por ID: {}", e.getMessage(), e);
        }
    }

    @Transactional
    public void updateProgressToComplete(Integer id) {
        try {
            UserRoadmapDataMapper userRoadmap = entityManager.find(UserRoadmapDataMapper.class, id);
            if (userRoadmap != null) {
                userRoadmap.setProgress(100.0);
                entityManager.merge(userRoadmap);
            } else {
                throw new RuntimeException("User roadmap not found for ID: " + id);
            }
        } catch (Exception e) {
            logger.error("Erro ao atualizar o progresso para 100% do roadmap ID: {}", id, e);
            throw new RuntimeException("Erro ao atualizar o progresso do roadmap", e);
        }
    }
}
