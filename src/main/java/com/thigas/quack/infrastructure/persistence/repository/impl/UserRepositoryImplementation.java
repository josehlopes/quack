package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.repository.IUserRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImplementation implements IUserRepository {

    private final UserMapper userMapper = UserMapper.INSTANCE;
    @Autowired
    private IUserModelRepository userModelRepository;

    @Override
    public UserEntity save(UserEntity address) {
        UserModel userModel = userMapper.EntityToModel(address);
        UserModel savedUserModel = userModelRepository.save(userModel);
        return userMapper.ModelToEntity(savedUserModel);
    }

    @Override
    public Optional<UserEntity> findById(int id) {
        return userModelRepository.findById(id).map(userMapper::ModelToEntity);
    }

    @Override
    public Iterable<UserEntity> findAll() {
        return userModelRepository.findAll().stream()
                .map(userMapper::ModelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        userModelRepository.deleteById(id);
    }
}
