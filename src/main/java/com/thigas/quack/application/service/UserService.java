package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.repository.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private final UserMapper userMapper = UserMapper.INSTANCE;
    @Autowired
    private IUserRepository userRepository;

    public UserDTO create(UserDTO userDTO) {
        UserEntity user = userMapper.dtoToEntity(userDTO);
        UserEntity toSaveUser = userRepository.save(user);
        return userMapper.entityToDto(toSaveUser);
    }

    public Optional<UserDTO> getById(int id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.map(userMapper::entityToDto);
    }

    public Iterable<UserDTO> getAll() {
        Iterable<UserEntity> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false).map(userMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public void update(UserDTO userDTO) {
        UserEntity existingUser = userRepository.findById(userDTO.getId())
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
        Optional<UserEntity> user = userRepository.findByEmail(email);
        return user.map(userMapper::entityToDto);
    }
}
