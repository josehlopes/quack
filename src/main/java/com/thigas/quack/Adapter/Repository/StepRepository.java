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
}
