package com.thigas.quack.Infrastructure.Repository;

import com.thigas.quack.Infrastructure.Model.LessonDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaLessonRepository extends JpaRepository<LessonDataMapper, Integer> {
}
