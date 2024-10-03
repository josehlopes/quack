package com.thigas.quack.infrastructure.persistence.repository.impl;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.adapter.mapper.UserTaskMapper;
import com.thigas.quack.domain.repository.IUserTaskRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserTaskModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserTaskModelRepository;

import jakarta.transaction.Transactional;

@Repository
public class UserTaskRepositoryImplementation implements IUserTaskRepository {

    @Autowired
    private IUserTaskModelRepository userTaskModelRepository;

    @Autowired
    private UserTaskMapper userTaskMapper;

    @Override
    @Transactional
    public UserTaskModel save(UserTaskModel userTaskModel) {
        return userTaskModelRepository.save(userTaskModel);
    }

    @Override
    @Transactional
    public Optional<UserTaskModel> findById(int id) {
        return userTaskModelRepository.findById(id);
    }

    @Override
    @Transactional
    public Iterable<UserTaskModel> findAll() {
        return userTaskModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userTaskModelRepository.deleteById(id);
    }
}