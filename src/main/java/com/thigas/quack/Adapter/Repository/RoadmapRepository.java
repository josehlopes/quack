package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.RoadmapDataMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RoadmapRepository {

    private static final Logger logger = LoggerFactory.getLogger(RoadmapRepository.class);
    private final EntityManager entityManager;

    @Transactional(readOnly = true)
    public Optional<RoadmapDataMapper> getById(Integer id) {
        try {
            return Optional.ofNullable(entityManager.find(RoadmapDataMapper.class, id));
        } catch (Exception e) {
            logger.error("Erro ao buscar roadmap por ID: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Integer id) {
        try {
            return entityManager.find(RoadmapDataMapper.class, id) != null;
        } catch (Exception e) {
            logger.error("Erro ao verificar se roadmap existe por ID: {}", e.getMessage(), e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    public Iterable<RoadmapDataMapper> getAll() {
        try {
            TypedQuery<RoadmapDataMapper> query = entityManager.createQuery(
                    "SELECT r FROM RoadmapDataMapper r", RoadmapDataMapper.class);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao buscar todos os roadmaps: {}", e.getMessage(), e);
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Iterable<RoadmapDataMapper> getByCategory(String category) {
        try {
            TypedQuery<RoadmapDataMapper> query = entityManager.createQuery(
                    "SELECT r FROM RoadmapDataMapper r WHERE r.category = :category", RoadmapDataMapper.class);
            query.setParameter("category", category);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao buscar roadmaps por categoria: {}", e.getMessage(), e);
        }
        return new ArrayList<>();
    }
}
