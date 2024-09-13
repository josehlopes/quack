package com.thigas.quack.domain.repository;

import java.util.Optional;
import com.thigas.quack.domain.entity.StepEntity;

public interface IStepRepository {
    StepEntity save(StepEntity step);

    Optional<StepEntity> findById(int id);

    Iterable<StepEntity> findAll();

    void deleteById(int id);
}
