package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.StepMapper;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.repository.IStepRepository;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IStepModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StepRepositoryImplementation implements IStepRepository {

    @Autowired
    private IStepModelRepository userModelRepository;
    private final StepMapper userMapper = StepMapper.INSTANCE;

    @Override
    public StepEntity save(StepEntity address) {
        StepModel userModel = userMapper.toStepModel(address);
        StepModel savedStepModel = userModelRepository.save(userModel);
        return userMapper.toStep(savedStepModel);
    }

    @Override
    public Optional<StepEntity> findById(int id) {
        return userModelRepository.findById(id).map(userMapper::toStep);
    }

    @Override
    public Iterable<StepEntity> findAll() {
        return userModelRepository.findAll().stream()
                .map(userMapper::toStep)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        userModelRepository.deleteById(id);
    }
}
