package com.thigas.quack.application.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.repository.IUserRepository;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    public UserDTO create(UserDTO userDTO) {
        // Converter DTO para entidade
        UserEntity user = userMapper.toUser(userDTO);
        // Salvar a entidade
        UserEntity toSaveUser = userRepository.save(user);
        // Converter entidade de volta para DTO
        return userMapper.toUserDTO(toSaveUser);
    }

    public Optional<UserDTO> getById(int id) {
        // Buscar a entidade do repositório
        Optional<UserEntity> user = userRepository.findById(id);
        // Converter a entidade para DTO
        return user.map(userMapper::toUserDTO);
    }

    public Iterable<UserDTO> getAll() {
        // Buscar todas as entidades
        Iterable<UserEntity> users = userRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(users.spliterator(), false)
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    public void update(UserDTO userDTO) {
        // Converter DTO para entidade
        UserEntity user = userMapper.toUser(userDTO);
        // Atualizar a entidade
        userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
