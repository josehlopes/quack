package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Dto.UserRoadmapDTO;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.Infrastructure.Entity.UserRoadmapDataMapper;
import com.thigas.quack.UseCase.Model.Request.RoadmapDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRoadmapDtoRequestModel;
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

    //TODO: Ajeitar o tipo de dados que vem do front, para não haver furos de camadas
    //TODO: Utilizar Gateways no lugar das services

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
        UserRoadmapDtoRequestModel userRoadmapDtoRequestModel = objectMapperService.toEntity(userRoadmapDTO);
        userRoadmapRepository.save(objectMapperService.toModel(userRoadmapDtoRequestModel));
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

        UserRoadmapDtoRequestModel updatedEntity = objectMapperService.toEntity(userRoadmapDTO);
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

        UserDtoRequestModel user = objectMapperService.toEntity(userService.getById(userId).orElse(null));
        RoadmapDtoRequestModel roadmap = objectMapperService.toEntity(roadmapService.getById(roadmapId).orElse(null));

        if (user == null || roadmap == null) {
            return false;
        }

        UserRoadmapDtoRequestModel userRoadmapDtoRequestModel = new UserRoadmapDtoRequestModel();
        userRoadmapDtoRequestModel.setUser(user);
        userRoadmapDtoRequestModel.setRoadmap(roadmap);
        userRoadmapDtoRequestModel.setProgress(0.0);
        userRoadmapDtoRequestModel.setStartedAt(LocalDate.now());
        userRoadmapDtoRequestModel.setStatus(Status.ACTIVE);

        UserRoadmapDataMapper userRoadmapDataMapper = objectMapperService.toModel(userRoadmapDtoRequestModel);
        userRoadmapRepository.save(userRoadmapDataMapper);

        return true;
    }

    public Boolean endRoadmap(int id) {
        UserRoadmapDTO existingUserRoadmap = getById(id)
                .orElseThrow(() -> new EntityNotFoundException("User-Roadmap not found"));


        UserRoadmapDtoRequestModel userRoadmapDtoRequestModel = objectMapperService.toEntity(existingUserRoadmap);

        if (existingUserRoadmap.getStartedAt() != null) {
            userRoadmapDtoRequestModel.setStartedAt(LocalDate.parse(existingUserRoadmap.getStartedAt()));
        }

        userRoadmapDtoRequestModel.setStatus(Status.FINISHED);
        userRoadmapDtoRequestModel.setFinishedAt(LocalDate.now());
        userRoadmapDtoRequestModel.setProgress(100.0);

        UserRoadmapDataMapper updatedModel = objectMapperService.toModel(userRoadmapDtoRequestModel);
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