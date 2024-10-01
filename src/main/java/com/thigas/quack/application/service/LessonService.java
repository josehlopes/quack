package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.adapter.mapper.LessonMapper;
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
    private LessonMapper lessonMapper;

    @Autowired
    private CycleAvoidingMappingContext context;

    public LessonDTO create(LessonDTO lessonDTO) {
        LessonModel lessonModel = lessonMapper.dtoToModel(lessonDTO, context);
        LessonModel savedLesson = lessonRepository.save(lessonModel);
        return lessonMapper.modelToDto(savedLesson, context);
    }

    public Set<LessonDTO> createAll(Set<LessonDTO> lessonDTOs, CycleAvoidingMappingContext context) {
        if (lessonDTOs == null || lessonDTOs.isEmpty()) {
            throw new IllegalArgumentException("LessonDTOs list cannot be null or empty");
        }

        Set<LessonModel> lessonEntities = lessonDTOs.stream()
                .map(dto -> lessonMapper.dtoToModel(dto, context))
                .collect(Collectors.toSet());

        Set<LessonModel> savedLessons;
        try {
            savedLessons = lessonRepository.saveAll(lessonEntities);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save lessons", e);
        }

        return savedLessons.stream()
                .map(entity -> lessonMapper.modelToDto(entity, context))
                .collect(Collectors.toSet());
    }


    public Optional<LessonDTO> getById(int id) {
        Optional<LessonModel> lessonOpt = lessonRepository.findById(id);
        return lessonOpt.map(lesson -> lessonMapper.modelToDto(lesson, new CycleAvoidingMappingContext()));
    }

    public Iterable<LessonDTO> getAll() {
        Iterable<LessonModel> lessons = lessonRepository.findAll();
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        return StreamSupport.stream(lessons.spliterator(), false)
                .map(lesson -> lessonMapper.modelToDto(lesson, context))
                .collect(Collectors.toSet());
    }

    public void update(LessonDTO lessonDTO) {
        LessonModel lesson = lessonMapper.dtoToModel(lessonDTO, context);
        lessonRepository.save(lesson);
    }

    public void deleteLesson(int id) {
        lessonRepository.deleteById(id);
    }
}
