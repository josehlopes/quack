package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserLessonDTO;
import com.thigas.quack.domain.entity.UserLessonEntity;
import com.thigas.quack.domain.repository.IUserLessonRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserLessonModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserLessonService {

    @Autowired
    private IUserLessonRepository userLessonRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    @Autowired
    private LessonService lessonService;

    @Autowired
    private UserService userService;


    public UserLessonDTO create(UserLessonDTO userLessonDTO) {
        UserLessonEntity userLessonEntity = objectMapperService.toEntity(userLessonDTO);
        UserLessonModel savedUserLesson = userLessonRepository.save(objectMapperService.toModel(userLessonEntity));
        return objectMapperService.toDto(savedUserLesson);
    }

    public Optional<UserLessonDTO> getById(int id) {
        return userLessonRepository.findById(id)
                .map(objectMapperService::toDto);
    }

    public Iterable<UserLessonDTO> getAll() {
        Iterable<UserLessonModel> userLessons = userLessonRepository.findAll();
        return StreamSupport.stream(userLessons.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }


    public void update(UserLessonDTO userLessonDTO) {
        UserLessonModel existingUserLesson = userLessonRepository.findById(userLessonDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User-Lesson not found"));

        UserLessonEntity updatedEntity = objectMapperService.toEntity(userLessonDTO);
        UserLessonModel updatedModel = objectMapperService.toModel(updatedEntity);

        userLessonRepository.save(updatedModel);
    }


    public void delete(int id) {
        userLessonRepository.deleteById(id);
    }
}