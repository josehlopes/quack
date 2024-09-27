package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.repository.IUserRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserModelRepository;

import jakarta.transaction.Transactional;

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
    @Transactional
    public UserEntity save(UserEntity userEntity) {
        UserModel userModel = userMapper.entityToModel(userEntity);
        UserModel savedUserModel = userModelRepository.save(userModel);
        return userMapper.modelToEntity(savedUserModel);
    }

    @Override
    @Transactional
    public Optional<UserEntity> findById(int id) {
        return userModelRepository.findById(id).map(userMapper::modelToEntity);
    }

    @Override
    @Transactional
    public Iterable<UserEntity> findAll() {
        return userModelRepository.findAll().stream().map(userMapper::modelToEntity).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userModelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<UserEntity> findByEmail(String email) {
        // Busque todos os usuários e filtre pelo e-mail
        return userModelRepository.findAll().stream().filter(userModel -> userModel.getEmail().equals(email))
                .map(userMapper::modelToEntity).findFirst();
    }
}
