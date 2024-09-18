package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.adapter.mapper.LessonMapper;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.repository.ILessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LessonService {

    private final LessonMapper lessonMapper = LessonMapper.INSTANCE;
    @Autowired
    private ILessonRepository lessonRepository;

    public Set<LessonDTO> createLessons(Set<LessonDTO> lessonDTOs) {
        Set<LessonEntity> lessons = lessonDTOs.stream()
                .map(lessonMapper::DtoToEntity)
                .collect(Collectors.toSet());

        Set<LessonEntity> savedLessons = lessonRepository.saveAll(lessons);

        return savedLessons.stream()
                .map(lessonMapper::EntityToDto)
                .collect(Collectors.toSet());
    }

    public Optional<LessonDTO> getLessonById(int id) {
        // Buscar a entidade do repositório
        Optional<LessonEntity> lesson = lessonRepository.findById(id);
        // Converter a entidade para DTO
        return lesson.map(lessonMapper::EntityToDto);
    }

    public Iterable<LessonDTO> getAllLessons() {
        // Buscar todas as entidades
        Iterable<LessonEntity> lessons = lessonRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(lessons.spliterator(), false)
                .map(lessonMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public void updateLesson(LessonDTO lessonDTO) {
        // Converter DTO para entidade
        LessonEntity lesson = lessonMapper.DtoToEntity(lessonDTO);
        // Atualizar a entidade
        lessonRepository.save(lesson);
    }

    public void deleteLesson(int id) {
        lessonRepository.deleteById(id);
    }
}
