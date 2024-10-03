package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
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

    @Autowired
    private CycleAvoidingMappingContext context;

    public UserDTO create(UserDTO userDTO) {
        UserModel user = userMapper.dtoToModel(userDTO, new CycleAvoidingMappingContext());
        UserModel savedUser = userRepository.save(user);
        return userMapper.modelToDto(savedUser, context);
    }

    public Optional<UserDTO> getById(int id) {
        Optional<UserModel> userOptional = userRepository.findById(id);
        return userOptional.map(user -> userMapper.modelToDto(user, new CycleAvoidingMappingContext()));
    }

    public Iterable<UserDTO> getAll() {
        Iterable<UserModel> users = userRepository.findAll();
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        return StreamSupport.stream(users.spliterator(), false).map(user -> userMapper.modelToDto(user, context))
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
        userRepository.deleteById(id);
    }


    public Optional<UserDTO> findByEmail(String email) {
        Optional<UserModel> userOptional = userRepository.findByEmail(email);
        return userOptional.map(user -> userMapper.modelToDto(user, new CycleAvoidingMappingContext()));
    }

}