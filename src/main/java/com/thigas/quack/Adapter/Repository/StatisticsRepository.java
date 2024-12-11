package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.StatisticsDataMapper;
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
public class StatisticsRepository {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsRepository.class);

    private final EntityManager entityManager;

    @Transactional
    public void save(StatisticsDataMapper statistics) {
        try {
            entityManager.persist(statistics);
        } catch (Exception e) {
            logger.error("Erro ao salvar endereço: {}", e.getMessage(), e);
        }
    }

    @Transactional
    public void update(StatisticsDataMapper statistics) {
        try {
            entityManager.merge(statistics);
        } catch (Exception e) {
            logger.error("Erro ao atualizar endereço: {}", e.getMessage(), e);
        }
    }

    @Transactional(readOnly = true)
    public Optional<StatisticsDataMapper> getById(Integer id) {
        try {
            return Optional.ofNullable(entityManager.find(StatisticsDataMapper.class, id));
        } catch (Exception e) {
            logger.error("Erro ao buscar endereço por ID: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Optional<StatisticsDataMapper> getUserStatistics(Integer userId) {
        try {
            TypedQuery<StatisticsDataMapper> query = entityManager.createQuery(
                    "SELECT a FROM StatisticsDataMapper a WHERE a.user.id = :user_id", StatisticsDataMapper.class);
            query.setParameter("user_id", userId);
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            logger.error("Erro ao buscar endereço do usuário: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Integer id) {
        try {
            return entityManager.find(StatisticsDataMapper.class, id) != null;
        } catch (Exception e) {
            logger.error("Erro ao verificar se endereço existe por ID: {}", e.getMessage(), e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    public Iterable<StatisticsDataMapper> getAll() {
        try {
            TypedQuery<StatisticsDataMapper> query = entityManager.createQuery(
                    "SELECT u FROM StatisticsDataMapper u", StatisticsDataMapper.class);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao buscar todos os usuários: {}", e.getMessage(), e);
        }
        return null;
    }

    @Transactional
    public void deleteById(Integer id) {
        try {
            StatisticsDataMapper user = entityManager.find(StatisticsDataMapper.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
        } catch (Exception e) {
            logger.error("Erro ao excluir endereço por ID: {}", e.getMessage(), e);
        }
    }
}
