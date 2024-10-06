package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.domain.repository.IUserRoadmapRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserRoadmapService {

    @Autowired
    private IUserRoadmapRepository userRoadmapRepository;

    @Autowired
    private ObjectMapperService objectMapperService;

    public UserRoadmapDTO create(UserRoadmapDTO userRoadmapDTO) {
        UserRoadmapModel userRoadmapModel = objectMapperService.toModel(userRoadmapDTO);
        UserRoadmapModel savedUserRoadmap = userRoadmapRepository.save(userRoadmapModel);
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
                .orElseThrow(() -> new EntityNotFoundException("UserRoadmap not found"));
        //TODO: Definir campo a ser atualizado
        existingUserRoadmap.setId(userRoadmapDTO.getId());
        userRoadmapRepository.save(existingUserRoadmap);
    }

    public void delete(int id) {
        if (!userRoadmapRepository.existsById(id)) {
            throw new IllegalArgumentException("UserRoadmap não encontrado com id: " + id);
        }
        userRoadmapRepository.deleteById(id);
    }
}
