package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.adapter.mapper.RoadmapMapper;
import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.adapter.mapper.UserRoadmapMapper;
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
        UserRoadmapModel userRoadmapModel = new UserRoadmapModel();
        boolean roadmapExists;
        boolean userExists;

        try {
            userExists = userRepository.existsById(userId);
            roadmapExists = roadmapRepository.existsById(roadmapId);
            if (!userExists || !roadmapExists) {
                return false;
            }


            UserModel user = userRepository.findById(userId).orElse(null);
            RoadmapModel roadmap = roadmapRepository.findById(roadmapId).orElse(null);


            if (user == null || roadmap == null) {
                return false;
            }


            userRoadmapModel.setUser(user);
            userRoadmapModel.setRoadmap(roadmap);
            userRoadmapModel.setProgress(0.0);
            userRoadmapModel.setStartedAt(LocalDate.now());


            userRoadmapModel = userRoadmapRepository.save(userRoadmapModel);
            return userRoadmapModel != null;

        } catch (Exception e) {
            System.out.println("Erro ao iniciar o roadmap: " + e.getMessage());
            return false;
        }
    }

    public Boolean endRoadmap(UserRoadmapDTO userRoadmapDTO) {
        UserRoadmapModel existingUserRoadmap =
                userRoadmapRepository.findById(userRoadmapDTO.getId())
                        .orElseThrow(() -> new EntityNotFoundException("User-Roadmap not found"));

        try {
            Optional<List<Object>> userRoadmapOptional =
                    findUserAndRoadmap(userRoadmapDTO.getUser(), userRoadmapDTO.getRoadmap());

            if (userRoadmapOptional.isEmpty()) {
                return false;
            }

            existingUserRoadmap.setUser((UserModel) userRoadmapOptional.get().get(0));
            existingUserRoadmap.setRoadmap((RoadmapModel) userRoadmapOptional.get().get(1));

            if (userRoadmapDTO.getStartedAt() != null) {
                existingUserRoadmap.setStartedAt(LocalDate.parse(userRoadmapDTO.getStartedAt()));
            }

            existingUserRoadmap.setStatus(Status.FINISHED);
            existingUserRoadmap.setFinishedAt(LocalDate.now());
            existingUserRoadmap.setProgress(100.0);

            userRoadmapRepository.save(existingUserRoadmap);
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao finalizar o roadmap: " + e.getMessage());
            return false;
        }
    }


    public Optional<List<Object>> findUserAndRoadmap(int userId, int roadmapId) {
        Optional<UserModel> userOptional = userRepository.findById(userId);
        Optional<RoadmapModel> roadmapOptional = roadmapRepository.findById(roadmapId);

        if (userOptional.isPresent() && roadmapOptional.isPresent()) {
            return Optional.of(Arrays.asList(userOptional.get(), roadmapOptional.get()));
        } else {
            System.out.println("Usuário ou roadmap não encontrado.");
            return Optional.empty();
        }
    }

}
