package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.adapter.mapper.*;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.domain.repository.IUserRepository;
import com.thigas.quack.domain.repository.IUserRoadmapRepository;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import jakarta.persistence.EntityNotFoundException;
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

    @Autowired
    private IRoadmapRepository roadmapRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IUserRoadmapRepository userRoadmapRepository;

    @Autowired
    private RoadmapMapper roadmapMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoadmapMapper userRoadmapMapper;

    @Autowired
    private CycleAvoidingMappingContext context;

    public RoadmapDTO create(RoadmapDTO roadmapDTO) {
        RoadmapModel roadmap = roadmapMapper.dtoToModel(roadmapDTO, context);
        RoadmapModel toSaveRoadmap = roadmapRepository.save(roadmap);
        return roadmapMapper.modelToDto(toSaveRoadmap, context);
    }

    public Optional<RoadmapDTO> getById(int id) {
        Optional<RoadmapModel> roadmapOpt = roadmapRepository.findById(id);
        return roadmapOpt.map(roadmap -> roadmapMapper.modelToDto(roadmap, new CycleAvoidingMappingContext()));
    }

    public Iterable<RoadmapDTO> getAll() {
        Iterable<RoadmapModel> roadmaps = roadmapRepository.findAll();
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        return StreamSupport.stream(roadmaps.spliterator(), false)
                .map(roadmap -> roadmapMapper.modelToDto(roadmap, context))
                .collect(Collectors.toList());
    }
    public void update(RoadmapDTO roadmapDTO) {
        RoadmapModel roadmap = roadmapMapper.dtoToModel(roadmapDTO, context);
        roadmapRepository.save(roadmap);
    }

    public void delete(int id) {
        roadmapRepository.deleteById(id);
    }

    public Boolean startRoadmap(int userId, int roadmapId) {
        UserRoadmapDTO userRoadmapDTO = new UserRoadmapDTO();
        UserRoadmapModel userRoadmapModel = new UserRoadmapModel();
        boolean roadmapExists;
        boolean userExists;

        try {
            userExists = userRepository.existsById(userId);
            roadmapExists = roadmapRepository.existsById(roadmapId);
            if (!userExists || !roadmapExists) {
                return false;
            }

            userRoadmapModel.setId(userId);
            userRoadmapModel.setId(roadmapId);
            userRoadmapModel.setProgress(0.0);
            userRoadmapModel.setStartedAt(LocalDate.now());

            userRoadmapRepository.save(userRoadmapModel);
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao iniciar o roadmap: " + e.getMessage());
            return false;
        }
    }

     public Boolean endRoadmap(UserRoadmapDTO userRoadmapDTO) {
     // Buscar UserRoadmap existente
     UserRoadmapModel existingUserRoadmap =
     userRoadmapRepository.findById(userRoadmapDTO.getId())
     .orElseThrow(() -> new EntityNotFoundException("User-Roadmap not found"));

     try {
     // Buscando o usuário e roadmap relacionados
     Optional<List<Object>> userRoadmapOptional =
     findUserAndRoadmap(userRoadmapDTO.getUser(),
     userRoadmapDTO.getRoadmap());

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
        Optional<UserModel> userOptional = userRepository.findById(userId);
        Optional<RoadmapModel> roadmapOptional = roadmapRepository.findById(roadmapId);

        if (userOptional.isPresent() && roadmapOptional.isPresent()) {
            // Retorna uma lista contendo o usuário e o roadmap
            return Optional.of(Arrays.asList(userOptional.get(), roadmapOptional.get()));
        } else {
            System.out.println("Usuário ou roadmap não encontrado.");
            return Optional.empty();
        }
    }

}
