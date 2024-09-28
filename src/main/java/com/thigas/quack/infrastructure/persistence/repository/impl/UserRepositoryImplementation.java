package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.github.javafaker.Bool;
import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.adapter.mapper.UserMapper;
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
    public UserModel save(UserModel userModel) {
        UserModel savedUserModel = userModelRepository.save(userModel);
        return savedUserModel;
    }

    @Override
    @Transactional
    public Optional<UserModel> findById(int id) {
        return userModelRepository.findById(id);
    }

    public Boolean existsById(int id) {
        return userModelRepository.existsById(id);
    }

    @Override
    @Transactional
    public Iterable<UserModel> findAll() {
        return userModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userModelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<UserModel> findByEmail(String email) {
        return userModelRepository.findByEmail(email);
    }
}
