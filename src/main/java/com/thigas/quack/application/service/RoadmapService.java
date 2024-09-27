package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.adapter.mapper.RoadmapMapper;
import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.adapter.mapper.UserRoadmapMapper;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.domain.repository.IUserRepository;
import com.thigas.quack.domain.repository.IUserRoadmapRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
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
        UserRoadmapEntity userRoadmapEntity = new UserRoadmapEntity();
        RoadmapEntity roadmap;
        UserEntity user;

        try {
            // Verificar se o usuário e o roadmap existem
            user = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado."));
            roadmap = roadmapRepository.findById(roadmapId)
                    .orElseThrow(() -> new EntityNotFoundException("Roadmap não encontrado."));

            // Criar um novo UserRoadmapEntity
            userRoadmapEntity.setId(user.getId());
            userRoadmapEntity.setId(roadmap.getId());
            userRoadmapEntity.setProgress(0.0);
            userRoadmapEntity.setStartedAt(LocalDate.now());

            // Salvar a associação no banco de dados
            userRoadmapRepository.save(userRoadmapEntity);
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao iniciar o roadmap: " + e.getMessage());
            return false;
        }
    }

    public Boolean endRoadmap(UserRoadmapDTO userRoadmapDTO) {
        // Buscar UserRoadmap existente
        UserRoadmapEntity existingUserRoadmap = userRoadmapRepository.findById(userRoadmapDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User-Roadmap not found"));

        try {
            // Buscando o usuário e roadmap relacionados
            Optional<List<Object>> userRoadmapOptional = findUserAndRoadmap(userRoadmapDTO.getUserId(),
                    userRoadmapDTO.getRoadmapId());

            if (userRoadmapOptional.isEmpty()) {
                return false; // Roadmap do usuário não encontrado
            }

            // Atualizando data de início se presente no DTO
            if (userRoadmapDTO.getStartedAt() != null) {
                existingUserRoadmap.setStartedAt(LocalDate.parse(userRoadmapDTO.getStartedAt()));
            }

            // Atualizando progresso para 100%
            existingUserRoadmap.setStatus(Status.FINISHED);
            existingUserRoadmap.setFinishedAt(LocalDate.now());
            existingUserRoadmap.setProgress(100.0);

            // Salvando alterações
            userRoadmapRepository.save(existingUserRoadmap);
            return true;

        } catch (Exception e) {
            // Substituir por um Logger apropriado
            System.out.println("Erro ao finalizar o roadmap: " + e.getMessage());
            return false;
        }
    }

    public Optional<List<Object>> findUserAndRoadmap(int userId, int roadmapId) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        Optional<RoadmapEntity> roadmapOptional = roadmapRepository.findById(roadmapId);

        if (userOptional.isPresent() && roadmapOptional.isPresent()) {
            return Optional.of(Arrays.asList(userOptional.get(), roadmapOptional.get()));
        } else {
            System.out.println("Usuário ou roadmap não encontrado.");
            return Optional.empty();
        }
    }

}
