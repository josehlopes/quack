package com.thigas.quack.domain.repository;

import com.thigas.quack.domain.entity.StepEntity;

import java.util.Optional;

public interface IStepRepository {
    StepEntity save(StepEntity user);

    Optional<StepEntity> findById(int id);

    Iterable<StepEntity> findAll();

    void deleteById(int id);
}
