package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.domain.repository.IUserRepository;
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
    private IRoadmapRepository roadmapRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    @Autowired
    private RoadmapService roadmapService;


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
    public Boolean startRoadmap(int userId, int roadmapId) {
        UserEntity userEntity = new UserEntity();
        boolean roadmapExists = roadmapService.existsById(roadmapId);
        boolean userExists = userRepository.existsById(userId);

            if (!userExists || !roadmapExists) {
                return false;
            }

            UserEntity user = objectMapperService.toEntity(userRepository.findById(userId).orElse(null));
            RoadmapEntity roadmap = objectMapperService.toEntity(roadmapRepository.findById(roadmapId).orElse(null));

            if (user == null || roadmap == null) {
                return false;
            }

            userEntity.setUser(user);
            userEntity.setRoadmap(roadmap);
            userEntity.setProgress(0.0);
            userEntity.setStartedAt(LocalDate.now());

            userEntity = userRoadmapRepository.save(userEntity);
            return userEntity != null;


    }

    public Boolean endRoadmap(UserRoadmapDTO userRoadmapDTO) {
        UserRoadmapModel existingUserRoadmap =
                userRoadmapRepository.findById(userRoadmapDTO.getId())
                        .orElseThrow(() -> new EntityNotFoundException("User-Roadmap not found"));

        try {
            Optional<List<Object>> userRoadmapOptional =
                    findUserAndRoadmap(userRoadmapDTO.getUser(), userRoadmapDTO.getRoadmap());

            if (userRoadmapOptional.isEmpty()) {
                return false;
            }

            existingUserRoadmap.setUser((UserModel) userRoadmapOptional.get().get(0));
            existingUserRoadmap.setRoadmap((RoadmapModel) userRoadmapOptional.get().get(1));

            if (userRoadmapDTO.getStartedAt() != null) {
                existingUserRoadmap.setStartedAt(LocalDate.parse(userRoadmapDTO.getStartedAt()));
            }

            existingUserRoadmap.setStatus(Status.FINISHED);
            existingUserRoadmap.setFinishedAt(LocalDate.now());
            existingUserRoadmap.setProgress(100.0);

            userRoadmapRepository.save(existingUserRoadmap);
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao finalizar o roadmap: " + e.getMessage());
            return false;
        }
    }

    public Boolean existsById (int userId) {
        return userRepository.existsById(userId);
    }
}
