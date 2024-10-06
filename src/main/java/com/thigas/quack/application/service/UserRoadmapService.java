package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.adapter.mapper.TaskMapper;
import com.thigas.quack.adapter.mapper.UserRoadmapMapper;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
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
    private UserRoadmapMapper userRoadmapMapper;

    @Autowired
    private CycleAvoidingMappingContext context;

    public UserRoadmapDTO create(UserRoadmapDTO userRoadmapDTO) {
        UserRoadmapModel userRoadmapModel = userRoadmapMapper.dtoToModel(userRoadmapDTO, context);
        UserRoadmapModel savedUserRoadmap = userRoadmapRepository.save(userRoadmapModel);
        return userRoadmapMapper.modelToDto(savedUserRoadmap, context);
    }

    public Optional<UserRoadmapDTO> getById(int id) {
        Optional<UserRoadmapModel> userRoadmapOpt = userRoadmapRepository.findById(id);
        return userRoadmapOpt.map(userRoadmap -> userRoadmapMapper.modelToDto(userRoadmap, new CycleAvoidingMappingContext()));
    }

    public Iterable<UserRoadmapDTO> getAll() {
        Iterable<UserRoadmapModel> userRoadmapsOpt = userRoadmapRepository.findAll();
        return StreamSupport.stream(userRoadmapsOpt.spliterator(), false).map(userRoadmap -> userRoadmapMapper.modelToDto(userRoadmap, new CycleAvoidingMappingContext())).collect(Collectors.toList());
    }

    public void update(UserRoadmapDTO userRoadmapDTO) {
        UserRoadmapModel existingUser = userRoadmapRepository.findById(userRoadmapDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        userRoadmapRepository.save(existingUser);
    }

    public void delete(int id) {
        userRoadmapRepository.deleteById(id);
    }
}
