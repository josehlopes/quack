package com.thigas.quack.infrastructure.persistence.repository.impl;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.adapter.mapper.UserTaskMapper;
import com.thigas.quack.domain.entity.UserTaskEntity;
import com.thigas.quack.domain.repository.IUserTaskRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserTaskModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserTaskModelRepository;

@Repository
public class UserTaskRepositoryImplementation implements IUserTaskRepository {

    @Autowired
    private IUserTaskModelRepository userTaskModelRepository;
    private final UserTaskMapper userTaskMapper = UserTaskMapper.INSTANCE;

    @Override
    public UserTaskEntity save(UserTaskEntity userTaskEntity) {
        UserTaskModel userTaskMODEL = userTaskMapper.entityToModel(userTaskEntity);
        UserTaskModel savedUserTaskModel = userTaskModelRepository.save(userTaskMODEL);
        return userTaskMapper.modelToEntity(savedUserTaskModel);
    }

    @Override
    public Optional<UserTaskEntity> findById(int id) {
        return userTaskModelRepository.findById(id).map(userTaskMapper::modelToEntity);
    }

    @Override
    public Iterable<UserTaskEntity> findAll() {
        return userTaskModelRepository.findAll().stream().map(userTaskMapper::modelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        userTaskModelRepository.deleteById(id);
    }
}