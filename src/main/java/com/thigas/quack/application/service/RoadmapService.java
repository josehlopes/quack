package com.thigas.quack.application.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.adapter.mapper.RoadmapMapper;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.repository.IRoadmapRepository;

@Service
public class RoadmapService {

    @Autowired
    private IRoadmapRepository roadmapRepository;

    // Instância do mapper
    private final RoadmapMapper roadmapMapper = RoadmapMapper.INSTANCE;

    public RoadmapDTO create(RoadmapDTO roadmapDTO) {
        // Converter DTO para entidade
        RoadmapEntity roadmap = roadmapMapper.toRoadmap(roadmapDTO);
        // Salvar a entidade
        RoadmapEntity toSaveRoadmap = roadmapRepository.save(roadmap);
        // Converter entidade de volta para DTO
        return roadmapMapper.toRoadmapDTO(toSaveRoadmap);
    }

    public Optional<RoadmapDTO> getById(Long id) {
        // Buscar a entidade do repositório
        Optional<RoadmapEntity> roadmap = roadmapRepository.findById(id);
        // Converter a entidade para DTO
        return roadmap.map(roadmapMapper::toRoadmapDTO);
    }

    public Iterable<RoadmapDTO> getAll() {
        // Buscar todas as entidades
        Iterable<RoadmapEntity> roadmaps = roadmapRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(roadmaps.spliterator(), false)
                .map(roadmapMapper::toRoadmapDTO)
                .collect(Collectors.toList());
    }

    public void update(RoadmapDTO roadmapDTO) {
        // Converter DTO para entidade
        RoadmapEntity roadmap = roadmapMapper.toRoadmap(roadmapDTO);
        // Atualizar a entidade
        roadmapRepository.save(roadmap);
    }

    public void delete(Long id) {
        roadmapRepository.deleteById(id);
    }
}
