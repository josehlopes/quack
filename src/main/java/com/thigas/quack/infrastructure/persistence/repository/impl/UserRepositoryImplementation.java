package com.thigas.quack.infrastructure.persistence.repository.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.repository.IUserRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserModelRepository;

@Repository
public class UserRepositoryImplementation implements IUserRepository {

    @Autowired
    private IUserModelRepository userModelRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public UserEntity save(UserEntity address) {
        UserModel userModel = userMapper.toUserModel(address);
        UserModel savedUserModel = userModelRepository.save(userModel);
        return userMapper.toUser(savedUserModel);
    }

    @Override
    public Optional<UserEntity> findById(int id) {
        return userModelRepository.findById(id).map(userMapper::toUser);
    }

    @Override
    public Iterable<UserEntity> findAll() {
        return userModelRepository.findAll().stream()
                .map(userMapper::toUser)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        userModelRepository.deleteById(id);
    }
}
