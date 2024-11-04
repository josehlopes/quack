package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Dto.UserRoadmapDTO;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.Infrastructure.Model.UserRoadmapDataMapper;
import com.thigas.quack.UseCase.Model.Request.RoadmapDsRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserDsRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRoadmapDsRequestModel;
import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Gateway.UserRoadmapDsGateway;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserRoadmapService {

    @Autowired
    private UserRoadmapDsGateway userRoadmapRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    @Autowired
    private RoadmapService roadmapService;

    @Autowired
    private UserService userService;

    @Autowired
    private StatisticsService statisticsService;


    public void create(UserRoadmapDTO userRoadmapDTO) {
        UserRoadmapDsRequestModel userRoadmapDsRequestModel = objectMapperService.toEntity(userRoadmapDTO);
        userRoadmapRepository.save(objectMapperService.toModel(userRoadmapDsRequestModel));
    }

    public Optional<UserRoadmapDTO> getById(int id) {
        return userRoadmapRepository.findById(id)
                .map(objectMapperService::toDto);
    }

    public Iterable<UserRoadmapDTO> getAll() {
        Iterable<UserRoadmapDataMapper> userRoadmaps = userRoadmapRepository.findAll();
        return StreamSupport.stream(userRoadmaps.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }


    public void update(UserRoadmapDTO userRoadmapDTO) {
        UserRoadmapDataMapper existingUserRoadmap = userRoadmapRepository.findById(userRoadmapDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User-Roadmap not found"));

        UserRoadmapDsRequestModel updatedEntity = objectMapperService.toEntity(userRoadmapDTO);
        UserRoadmapDataMapper updatedModel = objectMapperService.toModel(updatedEntity);

        userRoadmapRepository.save(updatedModel);
    }


    public void delete(int id) {
        userRoadmapRepository.deleteById(id);
    }

    public Boolean startRoadmap(int userId, int roadmapId) {
        if (!userService.existsById(userId) || !roadmapService.existsById(roadmapId)) {
            return false;
        }

        UserDsRequestModel user = objectMapperService.toEntity(userService.getById(userId).orElse(null));
        RoadmapDsRequestModel roadmap = objectMapperService.toEntity(roadmapService.getById(roadmapId).orElse(null));

        if (user == null || roadmap == null) {
            return false;
        }

        UserRoadmapDsRequestModel userRoadmapDsRequestModel = new UserRoadmapDsRequestModel();
        userRoadmapDsRequestModel.setUser(user);
        userRoadmapDsRequestModel.setRoadmap(roadmap);
        userRoadmapDsRequestModel.setProgress(0.0);
        userRoadmapDsRequestModel.setStartedAt(LocalDate.now());
        userRoadmapDsRequestModel.setStatus(Status.ACTIVE);

        UserRoadmapDataMapper userRoadmapDataMapper = objectMapperService.toModel(userRoadmapDsRequestModel);
        userRoadmapRepository.save(userRoadmapDataMapper);

        return true;
    }

    public Boolean endRoadmap(int id) {
        UserRoadmapDTO existingUserRoadmap = getById(id)
                .orElseThrow(() -> new EntityNotFoundException("User-Roadmap not found"));


        UserRoadmapDsRequestModel userRoadmapDsRequestModel = objectMapperService.toEntity(existingUserRoadmap);

        if (existingUserRoadmap.getStartedAt() != null) {
            userRoadmapDsRequestModel.setStartedAt(LocalDate.parse(existingUserRoadmap.getStartedAt()));
        }

        userRoadmapDsRequestModel.setStatus(Status.FINISHED);
        userRoadmapDsRequestModel.setFinishedAt(LocalDate.now());
        userRoadmapDsRequestModel.setProgress(100.0);

        UserRoadmapDataMapper updatedModel = objectMapperService.toModel(userRoadmapDsRequestModel);
        userRoadmapRepository.save(updatedModel);

        int userId = existingUserRoadmap.getUser().getId();
        statisticsService.incrementRoadmapsCompleted(userId);
        return true;
    }

//    public Boolean findUserAndRoadmap(int userId, int roadmapId) {
//        Boolean userOptional = userService.existsById(userId);
//        Boolean roadmapOptional = roadmapService.existsById(roadmapId);
//
//        if (userOptional && roadmapOptional) {
//            return true;
//        } else {
//            System.out.println("Usuário ou roadmap não encontrado.");
//            return false;
//        }
//    }

}