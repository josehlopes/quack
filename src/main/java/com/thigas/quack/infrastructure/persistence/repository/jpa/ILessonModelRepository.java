package com.thigas.quack.infrastructure.persistence.repository.jpa;

import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILessonModelRepository extends JpaRepository<LessonModel, Integer> {
}
