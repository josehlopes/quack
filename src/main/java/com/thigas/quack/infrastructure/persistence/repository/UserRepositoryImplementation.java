package com.thigas.quack.infrastructure.persistence.repository;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.domain.entity.User;
import com.thigas.quack.domain.repository.IUserRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;

@Repository
public class UserRepositoryImplementation implements IUserRepository {

    @Autowired
    private IUserModelRepository userModelRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public User save(User address) {
        UserModel userModel = userMapper.toUserModel(address);
        UserModel savedUserModel = userModelRepository.save(userModel);
        return userMapper.toUser(savedUserModel);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userModelRepository.findById(id).map(userMapper::toUser);
    }

    @Override
    public Iterable<User> findAll() {
        return userModelRepository.findAll().stream()
                .map(userMapper::toUser)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        userModelRepository.deleteById(id);
    }
}
