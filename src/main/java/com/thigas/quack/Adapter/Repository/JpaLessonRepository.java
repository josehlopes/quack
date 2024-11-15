package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.LessonDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaLessonRepository extends JpaRepository<LessonDataMapper, Integer> {
}
