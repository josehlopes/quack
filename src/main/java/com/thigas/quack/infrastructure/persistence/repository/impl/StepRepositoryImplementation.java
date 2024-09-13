package com.thigas.quack.infrastructure.persistence.repository.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import com.thigas.quack.adapter.mapper.StepMapper;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.repository.IStepRepository;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IStepModelRepository;

@Repository
public class StepRepositoryImplementation implements IStepRepository {

    @Autowired
    private IStepModelRepository stepModelRepository;
    private final StepMapper stepMapper = StepMapper.INSTANCE;

    @Override
    public StepEntity save(StepEntity step) {
        StepModel stepModel = stepMapper.EntityToModel(step);
        StepModel savedStepModel = stepModelRepository.save(stepModel);
        return stepMapper.ModelToEntity(savedStepModel);
    }

    @Override
    public Optional<StepEntity> findById(int id) {
        return stepModelRepository.findById(id).map(stepMapper::ModelToEntity);
    }

    @Override
    public Iterable<StepEntity> findAll() {
        return stepModelRepository.findAll().stream()
                .map(stepMapper::ModelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        stepModelRepository.deleteById(id);
    }

}
