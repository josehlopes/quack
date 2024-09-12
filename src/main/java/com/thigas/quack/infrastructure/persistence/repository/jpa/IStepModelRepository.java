package com.thigas.quack.infrastructure.persistence.repository.jpa;

import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStepModelRepository extends JpaRepository<StepModel, Integer> {
}
