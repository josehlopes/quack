package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.domain.repository.IUserRepository;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoadmapService {

    @Autowired
    private IRoadmapRepository roadmapRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    public RoadmapDTO create(RoadmapDTO roadmapDTO) {
        RoadmapModel roadmap = objectMapperService.toModel(roadmapDTO);
        RoadmapModel toSaveRoadmap = roadmapRepository.save(roadmap);
        return objectMapperService.toDto(toSaveRoadmap);
    }

    public Optional<RoadmapDTO> getById(int id) {
        Optional<RoadmapModel> roadmapOpt = roadmapRepository.findById(id);
        return roadmapOpt.map(objectMapperService::toDto);
    }

    public Iterable<RoadmapDTO> getAll() {
        Iterable<RoadmapModel> roadmaps = roadmapRepository.findAll();
        return StreamSupport.stream(roadmaps.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(RoadmapDTO roadmapDTO) {
        RoadmapModel roadmap = objectMapperService.toModel(roadmapDTO);
        roadmapRepository.save(roadmap);
    }

    public void delete(int id) {
        roadmapRepository.deleteById(id);
    }

    public Boolean existsById(int roadmapId) {
        return userRepository.existsById(roadmapId);
    }
}
