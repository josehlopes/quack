package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.adapter.mapper.RoadmapMapper;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoadmapService {

    // Instância do mapper
    private final RoadmapMapper roadmapMapper = RoadmapMapper.INSTANCE;
    @Autowired
    private IRoadmapRepository roadmapRepository;

    public RoadmapDTO create(RoadmapDTO roadmapDTO) {
        RoadmapEntity roadmap = roadmapMapper.dtoToEntity(roadmapDTO);
        RoadmapEntity toSaveRoadmap = roadmapRepository.save(roadmap);
        return roadmapMapper.entityToDto(toSaveRoadmap);
    }

    public Optional<RoadmapDTO> getById(int id) {
        Optional<RoadmapEntity> roadmap = roadmapRepository.findById(id);
        return roadmap.map(roadmapMapper::entityToDto);
    }

    public Iterable<RoadmapDTO> getAll() {
        Iterable<RoadmapEntity> roadmaps = roadmapRepository.findAll();
        return StreamSupport.stream(roadmaps.spliterator(), false).map(roadmapMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public void update(RoadmapDTO roadmapDTO) {
        RoadmapEntity roadmap = roadmapMapper.dtoToEntity(roadmapDTO);
        roadmapRepository.save(roadmap);
    }

    public void delete(int id) {
        roadmapRepository.deleteById(id);
    }
}
