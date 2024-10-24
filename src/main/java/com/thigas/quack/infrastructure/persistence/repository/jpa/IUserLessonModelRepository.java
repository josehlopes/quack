package com.thigas.quack.infrastructure.persistence.repository.jpa;

import com.thigas.quack.infrastructure.persistence.entity.UserLessonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserLessonModelRepository extends JpaRepository<UserLessonModel, Integer> {
}
