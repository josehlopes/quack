package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Dto.UserLessonDTO;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.Infrastructure.Model.UserLessonDataMapper;
import com.thigas.quack.UseCase.Model.Request.UserLessonDsRequestModel;
import com.thigas.quack.UseCase.Gateway.UserLessonDsGateway;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserLessonService {

    @Autowired
    private UserLessonDsGateway userLessonRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    @Autowired
    private LessonService lessonService;

    @Autowired
    private UserService userService;


    public void create(UserLessonDTO userLessonDTO) {
        UserLessonDsRequestModel userLessonDsRequestModel = objectMapperService.toEntity(userLessonDTO);
        userLessonRepository.save(objectMapperService.toModel(userLessonDsRequestModel));
    }

    public Optional<UserLessonDTO> getById(int id) {
        return userLessonRepository.findById(id)
                .map(objectMapperService::toDto);
    }

    public Iterable<UserLessonDTO> getAll() {
        Iterable<UserLessonDataMapper> userLessons = userLessonRepository.findAll();
        return StreamSupport.stream(userLessons.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }


    public void update(UserLessonDTO userLessonDTO) {
        UserLessonDataMapper existingUserLesson = userLessonRepository.findById(userLessonDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User-Lesson not found"));

        UserLessonDsRequestModel updatedEntity = objectMapperService.toEntity(userLessonDTO);
        UserLessonDataMapper updatedModel = objectMapperService.toModel(updatedEntity);

        userLessonRepository.save(updatedModel);
    }


    public void delete(int id) {
        userLessonRepository.deleteById(id);
    }
}