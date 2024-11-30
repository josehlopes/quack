package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.AchievementDataMapper;
import com.thigas.quack.Adapter.Entity.LessonDataMapper;
import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
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
public class LessonRepository {
    private static final Logger logger = LoggerFactory.getLogger(LessonDsGateway.class);
    private final EntityManager entityManager;

    @Transactional(readOnly = true)
    public Optional<LessonDataMapper> getById(Integer id) {
        try {
            return Optional.ofNullable(entityManager.find(LessonDataMapper.class, id));
        } catch (Exception e) {
            logger.error("Erro ao buscar lesson por ID: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Iterable<LessonDataMapper> getAll() {
        try {
            TypedQuery<LessonDataMapper> query = entityManager.createQuery(
                    "SELECT u FROM LessonDataMapper u", LessonDataMapper.class);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao buscar todos os lesson: {}", e.getMessage(), e);
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Integer id) {
        try {
            return entityManager.find(LessonDataMapper.class, id) != null;
        } catch (Exception e) {
            logger.error("Erro ao verificar se achievement existe por ID: {}", e.getMessage(), e);
        }
        return false;
    }
}
