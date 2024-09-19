package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.adapter.mapper.UserRoadmapMapper;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.domain.repository.IUserRoadmapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserRoadmapService {

    private final UserRoadmapMapper roadmapUserMapper = UserRoadmapMapper.INSTANCE;
    @Autowired
    private IUserRoadmapRepository roadmapUserRepository;

    public UserRoadmapDTO create(UserRoadmapDTO roadmapUserDTO) {
        UserRoadmapEntity roadmapUser = roadmapUserMapper.dtoToEntity(roadmapUserDTO);
        UserRoadmapEntity toSaveRoadmapUser = roadmapUserRepository.save(roadmapUser);
        return roadmapUserMapper.entityToDto(toSaveRoadmapUser);
    }

    public Optional<UserRoadmapDTO> getById(int id) {
        Optional<UserRoadmapEntity> roadmapUser = roadmapUserRepository.findById(id);
        return roadmapUser.map(roadmapUserMapper::entityToDto);
    }

    public Iterable<UserRoadmapDTO> getAll() {
        Iterable<UserRoadmapEntity> roadmapUsers = roadmapUserRepository.findAll();
        return StreamSupport.stream(roadmapUsers.spliterator(), false).map(roadmapUserMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public void update(UserRoadmapDTO roadmapUserDTO) {
        UserRoadmapEntity roadmapUser = roadmapUserMapper.dtoToEntity(roadmapUserDTO);
        roadmapUserRepository.save(roadmapUser);
    }

    public void delete(int id) {
        roadmapUserRepository.deleteById(id);
    }
}
