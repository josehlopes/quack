package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.UserLessonDataMapper;
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
public class UserLessonRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserLessonRepository.class);
    private final EntityManager entityManager;

    @Transactional
    public Boolean save(UserLessonDataMapper userLesson) {
        try {
            entityManager.persist(userLesson);
            return true;
        } catch (Exception e) {
            logger.error("Erro ao salvar roadmap: {}", e.getMessage(), e);
            return false;
        }
    }

    @Transactional
    public void update(UserLessonDataMapper userLesson) {
        try {
            entityManager.merge(userLesson);
        } catch (Exception e) {
            logger.error("Erro ao atualizar lição: {}", e.getMessage(), e);
        }
    }

    @Transactional(readOnly = true)
    public Optional<UserLessonDataMapper> getById(Integer id) {
        try {
            UserLessonDataMapper result = entityManager.find(UserLessonDataMapper.class, id);
            logger.info("Resultado para ID {}: {}", id, result);
            return Optional.ofNullable(result);
        } catch (Exception e) {
            logger.error("Erro ao buscar lição por ID: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }


    @Transactional(readOnly = true)
    public Boolean existsById(Integer id) {
        try {
            return entityManager.find(UserLessonDataMapper.class, id) != null;
        } catch (Exception e) {
            logger.error("Erro ao verificar se lição existe por ID: {}", e.getMessage(), e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    public Boolean existsByUserIdAndLessonId(Integer userId, Integer lessonId) {
        try {
            TypedQuery<Long> query = entityManager.createQuery(
                    "SELECT COUNT(a) FROM UserLessonDataMapper a WHERE a.user.id = :user_id AND a.lesson.id = :lesson_id", Long.class);
            query.setParameter("user_id", userId);
            query.setParameter("lesson_id", lessonId);
            return query.getSingleResult() > 0;
        } catch (Exception e) {
            logger.error("Erro ao verificar se lição existe por userId e lessonId: {}", e.getMessage(), e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    public Optional<UserLessonDataMapper> findById(Integer id) {
        try {
            return Optional.ofNullable(entityManager.find(UserLessonDataMapper.class, id));
        } catch (Exception e) {
            logger.error("Erro ao buscar UserLesson pelo ID: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Transactional(readOnly = true)
    public List<UserLessonDataMapper> findByUserId(Integer userId) {
        try {
            TypedQuery<UserLessonDataMapper> query = entityManager.createQuery(
                    "SELECT ul FROM UserLessonDataMapper ul WHERE ul.user.id = :userId", UserLessonDataMapper.class);
            query.setParameter("userId", userId);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao buscar UserLessons por userId: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }


    @Transactional(readOnly = true)
    public Optional<UserLessonDataMapper> findByUserIdAndLessonId(Integer userId, Integer lessonId) {
        try {
            TypedQuery<UserLessonDataMapper> query = entityManager.createQuery(
                    "SELECT a FROM UserLessonDataMapper a WHERE a.user.id = :user_id AND a.lesson.id = :lesson_id", UserLessonDataMapper.class);
            query.setParameter("user_id", userId);
            query.setParameter("lesson_id", lessonId);
            return query.getResultStream().findFirst();
        } catch (Exception e) {
            logger.error("Erro ao buscar lição do usuário por userId e lessonId: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }


    @Transactional
    public void deleteById(Integer id) {
        try {
            UserLessonDataMapper userLesson = entityManager.find(UserLessonDataMapper.class, id);
            if (userLesson != null) {
                entityManager.remove(userLesson);
            }
        } catch (Exception e) {
            logger.error("Erro ao excluir lição por ID: {}", e.getMessage(), e);
        }
    }
}
