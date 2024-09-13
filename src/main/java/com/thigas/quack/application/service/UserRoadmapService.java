package com.thigas.quack.application.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thigas.quack.adapter.dto.RoadmapUserDTO;
import com.thigas.quack.adapter.mapper.UserRoadmapMapper;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.domain.repository.IUserRoadmapRepository;

@Service
public class UserRoadmapService {

    @Autowired
    private IUserRoadmapRepository roadmapUserRepository;
    private final UserRoadmapMapper roadmapUserMapper = UserRoadmapMapper.INSTANCE;

    public RoadmapUserDTO create(RoadmapUserDTO roadmapUserDTO) {
        // Converter DTO para entidade
        UserRoadmapEntity roadmapUser = roadmapUserMapper.DtoToEntity(roadmapUserDTO);
        // Salvar a entidade
        UserRoadmapEntity toSaveRoadmapUser = roadmapUserRepository.save(roadmapUser);
        // Converter entidade de volta para DTO
        return roadmapUserMapper.EntityToDto(toSaveRoadmapUser);
    }

    public Optional<RoadmapUserDTO> getById(int id) {
        // Buscar a entidade do repositório
        Optional<UserRoadmapEntity> roadmapUser = roadmapUserRepository.findById(id);
        // Converter a entidade para DTO
        return roadmapUser.map(roadmapUserMapper::EntityToDto);
    }

    public Iterable<RoadmapUserDTO> getAll() {
        // Buscar todas as entidades
        Iterable<UserRoadmapEntity> roadmapUsers = roadmapUserRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(roadmapUsers.spliterator(), false)
                .map(roadmapUserMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public void update(RoadmapUserDTO roadmapUserDTO) {
        // Converter DTO para entidade
        UserRoadmapEntity roadmapUser = roadmapUserMapper.DtoToEntity(roadmapUserDTO);
        // Atualizar a entidade
        roadmapUserRepository.save(roadmapUser);
    }

    public void delete(int id) {
        roadmapUserRepository.deleteById(id);
    }
}
