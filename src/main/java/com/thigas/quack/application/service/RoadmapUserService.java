package com.thigas.quack.application.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thigas.quack.adapter.dto.RoadmapUserDTO;
import com.thigas.quack.adapter.mapper.RoadmapUserMapper;
import com.thigas.quack.domain.entity.RoadmapUserEntity;
import com.thigas.quack.domain.repository.IRoadmapUserRepository;

@Service
public class RoadmapUserService {

    @Autowired
    private IRoadmapUserRepository roadmapUserRepository;
    private final RoadmapUserMapper roadmapUserMapper = RoadmapUserMapper.INSTANCE;

    public RoadmapUserDTO create(RoadmapUserDTO roadmapUserDTO) {
        // Converter DTO para entidade
        RoadmapUserEntity roadmapUser = roadmapUserMapper.toRoadmapUserEntity(roadmapUserDTO);
        // Salvar a entidade
        RoadmapUserEntity toSaveRoadmapUser = roadmapUserRepository.save(roadmapUser);
        // Converter entidade de volta para DTO
        return roadmapUserMapper.toRoadmapUserDTO(toSaveRoadmapUser);
    }

    public Optional<RoadmapUserDTO> getById(Long id) {
        // Buscar a entidade do repositório
        Optional<RoadmapUserEntity> roadmapUser = roadmapUserRepository.findById(id);
        // Converter a entidade para DTO
        return roadmapUser.map(roadmapUserMapper::toRoadmapUserDTO);
    }

    public Iterable<RoadmapUserDTO> getAll() {
        // Buscar todas as entidades
        Iterable<RoadmapUserEntity> roadmapUsers = roadmapUserRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(roadmapUsers.spliterator(), false)
                .map(roadmapUserMapper::toRoadmapUserDTO)
                .collect(Collectors.toList());
    }

    public void update(RoadmapUserDTO roadmapUserDTO) {
        // Converter DTO para entidade
        RoadmapUserEntity roadmapUser = roadmapUserMapper.toRoadmapUserEntity(roadmapUserDTO);
        // Atualizar a entidade
        roadmapUserRepository.save(roadmapUser);
    }

    public void delete(Long id) {
        roadmapUserRepository.deleteById(id);
    }
}
