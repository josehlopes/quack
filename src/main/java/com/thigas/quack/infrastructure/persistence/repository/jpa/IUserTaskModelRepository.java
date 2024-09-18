package com.thigas.quack.infrastructure.persistence.repository.jpa;

import com.thigas.quack.infrastructure.persistence.entity.UserTaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserTaskModelRepository extends JpaRepository<UserTaskModel, Integer> {
}