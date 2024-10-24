package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.domain.repository.IUserRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImplementation implements IUserRepository {

    @Autowired
    private IUserModelRepository userModelRepository;

    @Override
    @Transactional
    public UserModel save(UserModel userEntity) {
        return userModelRepository.save(userEntity);
    }

    @Override
    @Transactional
    public Optional<UserModel> findById(int id) {
        return userModelRepository.findById(id);
    }

    @Override
    @Transactional
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
