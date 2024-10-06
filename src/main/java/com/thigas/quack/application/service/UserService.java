package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.domain.repository.IUserRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDTO create(UserDTO userDTO) {
        UserModel user = userMapper.dtoToModel(userDTO);
        UserModel savedUser = userRepository.save(user);
        return userMapper.modelToDto(savedUser);
    }

    public Optional<UserDTO> getById(int id) {
        return userRepository.findById(id)
                .map(userMapper::modelToDto);
    }

    public Iterable<UserDTO> getAll() {
        Iterable<UserModel> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(userMapper::modelToDto)
                .collect(Collectors.toList());
    }

    public void update(UserDTO userDTO) {
        UserModel existingUser = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (userDTO.getName() != null) {
            existingUser.setName(userDTO.getName());
        }
        if (userDTO.getBornAt() != null) {
            existingUser.setBornAt(LocalDate.parse(userDTO.getBornAt()));
        }

        userRepository.save(existingUser);
    }

    public void delete(int id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }

    public Optional<UserDTO> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::modelToDto);
    }
}
