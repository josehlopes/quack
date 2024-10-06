package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.domain.repository.ILessonRepository;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LessonService {

    @Autowired
    private ILessonRepository lessonRepository;

    @Autowired
    private ObjectMapperService objectMapperService;

    public LessonDTO create(LessonDTO lessonDTO) {
        LessonModel lessonModel = objectMapperService.toModel(lessonDTO);
        LessonModel savedLesson = lessonRepository.save(lessonModel);
        return objectMapperService.toDto(savedLesson);
    }

    public Set<LessonDTO> createAll(Set<LessonDTO> lessonDTOs) {
        if (lessonDTOs == null || lessonDTOs.isEmpty()) {
            throw new IllegalArgumentException("LessonDTOs list cannot be null or empty");
        }

        Set<LessonModel> lessonEntities = lessonDTOs.stream()
                .map(objectMapperService::toModel)
                .collect(Collectors.toSet());

        Set<LessonModel> savedLessons;
        try {
            savedLessons = lessonRepository.saveAll(lessonEntities);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save lessons", e);
        }

        return savedLessons.stream()
                .map(objectMapperService::toDto) // Usando ObjectMapperService
                .collect(Collectors.toSet());
    }

    public Optional<LessonDTO> getById(int id) {
        Optional<LessonModel> lessonOpt = lessonRepository.findById(id);
        return lessonOpt.map(objectMapperService::toDto);
    }

    public Iterable<LessonDTO> getAll() {
        Iterable<LessonModel> lessons = lessonRepository.findAll();
        return StreamSupport.stream(lessons.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(LessonDTO lessonDTO) {
        LessonModel lesson = objectMapperService.toModel(lessonDTO);
        lessonRepository.save(lesson);
    }

    public void deleteLesson(int id) {
        lessonRepository.deleteById(id);
    }
}
