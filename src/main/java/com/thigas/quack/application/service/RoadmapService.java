package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.adapter.mapper.RoadmapMapper;
import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.adapter.mapper.UserRoadmapMapper;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.domain.repository.IUserRepository;
import com.thigas.quack.domain.repository.IUserRoadmapRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoadmapService {

    // Instância do mapper
    private final RoadmapMapper roadmapMapper = RoadmapMapper.INSTANCE;
    private final UserMapper userMapper = UserMapper.INSTANCE;
    private final UserRoadmapMapper userRoadmapMapper = UserRoadmapMapper.INSTANCE;

    @Autowired
    private IRoadmapRepository roadmapRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IUserRoadmapRepository userRoadmapRepository;

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

    public Boolean startRoadmap(int userId, int roadmapId) {

        UserRoadmapDTO userRoadmapDTO = new UserRoadmapDTO();
        UserRoadmapEntity userRoadmapEntity;

        try {
            Optional<UserEntity> userOptional = userRepository.findById(userId);
            Optional<RoadmapEntity> roadmapOptional = roadmapRepository.findById(roadmapId);

            if (userOptional.isEmpty() || roadmapOptional.isEmpty()) {
                System.out.println("Usuário ou roadmap não encontrado.");
                return false;
            }

            userRoadmapDTO.setUserId(userOptional.get().getId());
            userRoadmapDTO.setRoadmapId(roadmapOptional.get().getId());
            userRoadmapDTO.setProgress(0.0);
            userRoadmapDTO.setStartedAt(LocalDate.now().toString());

            userRoadmapEntity = userRoadmapMapper.dtoToEntity(userRoadmapDTO);
            userRoadmapRepository.save(userRoadmapEntity);
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao iniciar o roadmap: " + e.getMessage());
            return false;
        }
    }
}
