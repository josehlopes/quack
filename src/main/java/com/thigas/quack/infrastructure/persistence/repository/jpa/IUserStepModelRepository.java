package com.thigas.quack.infrastructure.persistence.repository.jpa;

import com.thigas.quack.infrastructure.persistence.entity.UserStepModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserStepModelRepository extends JpaRepository<UserStepModel, Integer> {
}
