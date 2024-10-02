package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.adapter.mapper.StepMapper;
import com.thigas.quack.domain.repository.IStepRepository;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IStepModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StepRepositoryImplementation implements IStepRepository {

    @Autowired
    private StepMapper stepMapper;

    @Autowired
    private CycleAvoidingMappingContext context;


    @Autowired
    private IStepModelRepository stepModelRepository;

    @Override
    @Transactional
    public StepModel save(StepModel stepModel) {
        return stepModelRepository.save(stepModel);
    }

    @Override
    @Transactional
    public Optional<StepModel> findById(int id) {
        return stepModelRepository.findById(id);
    }

    @Override
    @Transactional
    public Boolean existsById(int id) {
        return stepModelRepository.existsById(id);
    }


    @Override
    @Transactional
    public Iterable<StepModel> findAll() {
        return stepModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        stepModelRepository.deleteById(id);
    }

}
