package com.thigas.quack.domain.repository;


import com.thigas.quack.infrastructure.persistence.entity.StepModel;

import java.util.Optional;

public interface IStepRepository {
    StepModel save(StepModel step);

    Boolean existsById(int id);

    Optional<StepModel> findById(int id);

    Iterable<StepModel> findAll();

    void deleteById(int id);
}
