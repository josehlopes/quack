package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.domain.repository.IUserRepository;
import com.thigas.quack.domain.repository.IUserRoadmapRepository;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    public UserDTO create(UserDTO userDTO) {
        UserModel user = objectMapperService.toModel(userDTO);
        UserModel savedUser = userRepository.save(user);
        return objectMapperService.toDto(savedUser);
    }

    public Optional<UserDTO> getById(int id) {
        return userRepository.findById(id)
                .map(objectMapperService::toDto);
    }

    public Iterable<UserDTO> getAll() {
        Iterable<UserModel> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(objectMapperService::toDto)
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
                .map(objectMapperService::toDto);
    }


    //TODO: Recuperar as outras classes, DTOS, Entities

    public Boolean existsById (int userId) {
        return userRepository.existsById(userId);
    }
}
