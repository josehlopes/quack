package com.thigas.quack.Infrastructure.Repository;

import com.thigas.quack.Infrastructure.Model.UserLessonDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserLessonRepository extends JpaRepository<UserLessonDataMapper, Integer> {
}
