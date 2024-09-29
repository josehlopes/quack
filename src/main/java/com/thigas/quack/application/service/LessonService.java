package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.adapter.mapper.AchievementMapper;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.adapter.mapper.LessonMapper;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.repository.ILessonRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
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
        LessonEntity lessonEntity = lessonMapper.dtoToEntity(lessonDTO, context);
        LessonEntity savedLesson = lessonRepository.save(lessonEntity);
        return lessonMapper.entityToDto(savedLesson, context);
    }

//    public Set<LessonDTO> createAll(Set<LessonDTO> lessonDTOs) {
//        Set<LessonEntity> lessonEntities = lessonDTOs.stream().map(lessonMapper::dtoToEntity)
//                .collect(Collectors.toSet());
//
//        Set<LessonEntity> savedLessons = lessonRepository.saveAll(lessonEntities);
//        return savedLessons.stream().map(lessonMapper::entityToDto).collect(Collectors.toSet());
//    }

    public Optional<LessonDTO> getById(int id) {
        Optional<LessonEntity> lessonOpt = lessonRepository.findById(id);
        return lessonOpt.map(lesson -> lessonMapper.entityToDto(lesson, new CycleAvoidingMappingContext()));
    }

    public Iterable<LessonDTO> getAll() {
        Iterable<LessonEntity> lessons = lessonRepository.findAll();
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        return StreamSupport.stream(lessons.spliterator(), false)
                .map(lesson -> lessonMapper.entityToDto(lesson, context))
                .collect(Collectors.toList());
    }

    public void update(LessonDTO lessonDTO) {
        LessonEntity lesson = lessonMapper.dtoToEntity(lessonDTO, context);
        lessonRepository.save(lesson);
    }

    public void deleteLesson(int id) {
        lessonRepository.deleteById(id);
    }
}
