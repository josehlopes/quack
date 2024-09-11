package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.domain.entity.User;
import com.thigas.quack.domain.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    public UserDTO createUser(UserDTO userDTO) {
        // Converter DTO para entidade
        User address = userMapper.toUser(userDTO);
        // Salvar a entidade
        User toSaveUser = userRepository.save(address);
        // Converter entidade de volta para DTO
        return userMapper.toUserDTO(toSaveUser);
    }

    public Optional<UserDTO> getUserById(Long id) {
        // Buscar a entidade do repositório
        Optional<User> address = userRepository.findById(id);
        // Converter a entidade para DTO
        return address.map(userMapper::toUserDTO);
    }

    public Iterable<UserDTO> getAllUsers() {
        // Buscar todas as entidades
        Iterable<User> addresses = userRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(addresses.spliterator(), false)
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    public void updateUser(UserDTO userDTO) {
        // Converter DTO para entidade
        User address = userMapper.toUser(userDTO);
        // Atualizar a entidade
        userRepository.save(address);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
