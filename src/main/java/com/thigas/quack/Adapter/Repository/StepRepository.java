package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.StepDataMapper;
import com.thigas.quack.UseCase.Gateway.StepDsGateway;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class StepRepository {
    private static final Logger logger = LoggerFactory.getLogger(StepDsGateway.class);
    private final EntityManager entityManager;

    @Transactional(readOnly = true)
    public Optional<StepDataMapper> getById(Integer id) {
        try {
            return Optional.ofNullable(entityManager.find(StepDataMapper.class, id));
        } catch (Exception e) {
            logger.error("Erro ao buscar step por ID: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Iterable<StepDataMapper> getAll() {
        try {
            TypedQuery<StepDataMapper> query = entityManager.createQuery(
                    "SELECT u FROM StepDataMapper u", StepDataMapper.class);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao buscar todos os steps: {}", e.getMessage(), e);
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Integer id) {
        try {
            return entityManager.find(StepDataMapper.class, id) != null;
        } catch (Exception e) {
            logger.error("Erro ao verificar se step existe por ID: {}", e.getMessage(), e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    public List<StepDataMapper> getStepsByRoadmapId(Integer roadmapId) {
        try {
            TypedQuery<StepDataMapper> query = entityManager.createQuery(
                    "SELECT s FROM StepDataMapper s JOIN s.roadmaps r WHERE r.id = :roadmapId",
                    StepDataMapper.class
            );
            query.setParameter("roadmapId", roadmapId);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao buscar steps por roadmapId: {}", e.getMessage(), e);
        }
        return Collections.emptyList();
    }

}
