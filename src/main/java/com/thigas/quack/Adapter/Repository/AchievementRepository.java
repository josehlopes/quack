package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.AchievementDataMapper;
import com.thigas.quack.UseCase.Gateway.AchievementDsGateway;
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
public class AchievementRepository {

    private static final Logger logger = LoggerFactory.getLogger(AchievementDsGateway.class);
    private final EntityManager entityManager;

    @Transactional(readOnly = true)
    public Optional<AchievementDataMapper> getById(Integer id) {
        try {
            return Optional.ofNullable(entityManager.find(AchievementDataMapper.class, id));
        } catch (Exception e) {
            logger.error("Erro ao buscar achievement por ID: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Iterable<AchievementDataMapper> getAll() {
        try {
            TypedQuery<AchievementDataMapper> query = entityManager.createQuery(
                    "SELECT u FROM AchievementDataMapper u", AchievementDataMapper.class);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao buscar todos os achievements: {}", e.getMessage(), e);
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Integer id) {
        try {
            return entityManager.find(AchievementDataMapper.class, id) != null;
        } catch (Exception e) {
            logger.error("Erro ao verificar se achievement existe por ID: {}", e.getMessage(), e);
        }
        return false;
    }

}
