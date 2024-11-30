package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.StepDataMapper;
import com.thigas.quack.Adapter.Entity.TaskDataMapper;
import com.thigas.quack.UseCase.Gateway.TaskDsGateway;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Repository
@AllArgsConstructor
public class TaskRepository {
    private static final Logger logger = LoggerFactory.getLogger(TaskDsGateway.class);
    private final EntityManager entityManager;

    @Transactional(readOnly = true)
    public Optional<TaskDataMapper> getById(Integer id) {
        try {
            return Optional.ofNullable(entityManager.find(TaskDataMapper.class, id));
        } catch (Exception e) {
            logger.error("Erro ao buscar task por ID: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Iterable<TaskDataMapper> getAll() {
        try {
            TypedQuery<TaskDataMapper> query = entityManager.createQuery(
                    "SELECT u FROM TaskDataMapper u", TaskDataMapper.class);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao buscar todos as tasks: {}", e.getMessage(), e);
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Integer id) {
        try {
            return entityManager.find(TaskDataMapper.class, id) != null;
        } catch (Exception e) {
            logger.error("Erro ao verificar se task existe por ID: {}", e.getMessage(), e);
        }
        return false;
    }
}
