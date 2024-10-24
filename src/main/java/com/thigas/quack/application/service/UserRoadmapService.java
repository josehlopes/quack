package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.domain.repository.IUserRoadmapRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserRoadmapService {

    @Autowired
    private IUserRoadmapRepository userRoadmapRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    @Autowired
    private RoadmapService roadmapService;

    @Autowired
    private UserService userService;


    public UserRoadmapDTO create(UserRoadmapDTO userRoadmapDTO) {
        UserRoadmapEntity userRoadmapEntity = objectMapperService.toEntity(userRoadmapDTO);
        UserRoadmapModel savedUserRoadmap = userRoadmapRepository.save(objectMapperService.toModel(userRoadmapEntity));
        return objectMapperService.toDto(savedUserRoadmap);
    }

    public Optional<UserRoadmapDTO> getById(int id) {
        return userRoadmapRepository.findById(id)
                .map(objectMapperService::toDto);
    }

    public Iterable<UserRoadmapDTO> getAll() {
        Iterable<UserRoadmapModel> userRoadmaps = userRoadmapRepository.findAll();
        return StreamSupport.stream(userRoadmaps.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }


    public void update(UserRoadmapDTO userRoadmapDTO) {
        UserRoadmapModel existingUserRoadmap = userRoadmapRepository.findById(userRoadmapDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User-Roadmap not found"));

        UserRoadmapEntity updatedEntity = objectMapperService.toEntity(userRoadmapDTO);
        UserRoadmapModel updatedModel = objectMapperService.toModel(updatedEntity);

        userRoadmapRepository.save(updatedModel);
    }


    public void delete(int id) {
        userRoadmapRepository.deleteById(id);
    }

    public Boolean startRoadmap(int userId, int roadmapId) {
        if (!userService.existsById(userId) || !roadmapService.existsById(roadmapId)) {
            return false;
        }

        UserEntity user = objectMapperService.toEntity(userService.getById(userId).orElse(null));
        RoadmapEntity roadmap = objectMapperService.toEntity(roadmapService.getById(roadmapId).orElse(null));

        if (user == null || roadmap == null) {
            return false;
        }

        UserRoadmapEntity userRoadmapEntity = new UserRoadmapEntity();
        userRoadmapEntity.setUser(user);
        userRoadmapEntity.setRoadmap(roadmap);
        userRoadmapEntity.setProgress(0.0);
        userRoadmapEntity.setStartedAt(LocalDate.now());
        userRoadmapEntity.setStatus(Status.ACTIVE);

        UserRoadmapModel userRoadmapModel = objectMapperService.toModel(userRoadmapEntity);
        userRoadmapRepository.save(userRoadmapModel);

        return true;
    }

    public Boolean endRoadmap(int id) {
        UserRoadmapDTO existingUserRoadmap = getById(id)
                .orElseThrow(() -> new EntityNotFoundException("User-Roadmap not found"));


        UserRoadmapEntity userRoadmapEntity = objectMapperService.toEntity(existingUserRoadmap);

        if (existingUserRoadmap.getStartedAt() != null) {
            userRoadmapEntity.setStartedAt(LocalDate.parse(existingUserRoadmap.getStartedAt()));
        }

        userRoadmapEntity.setStatus(Status.FINISHED);
        userRoadmapEntity.setFinishedAt(LocalDate.now());
        userRoadmapEntity.setProgress(100.0);

        UserRoadmapModel updatedModel = objectMapperService.toModel(userRoadmapEntity);
        userRoadmapRepository.save(updatedModel);
        return true;
    }

//    public Boolean findUserAndRoadmap(int userId, int roadmapId) {
//        Boolean userOptional = userService.existsById(userId);
//        Boolean roadmapOptional = roadmapService.existsById(roadmapId);
//
//        if (userOptional && roadmapOptional) {
//            return true;
//        } else {
//            System.out.println("Usuário ou roadmap não encontrado.");
//            return false;
//        }
//    }

}