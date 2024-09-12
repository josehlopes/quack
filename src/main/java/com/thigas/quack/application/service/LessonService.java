package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.adapter.mapper.LessonMapper;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.repository.ILessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LessonService {

    @Autowired
    private ILessonRepository lessonRepository;

    private final LessonMapper lessonMapper = LessonMapper.INSTANCE;

    public LessonDTO createLesson(LessonDTO lessonDTO) {
        // Converter DTO para entidade
        LessonEntity lesson = lessonMapper.toLesson(lessonDTO);
        // Salvar a entidade
        LessonEntity savedLesson = lessonRepository.save(lesson);
        // Converter entidade de volta para DTO
        return lessonMapper.toLessonDTO(savedLesson);
    }

    public Optional<LessonDTO> getLessonById(Long id) {
        // Buscar a entidade do repositório
        Optional<LessonEntity> lesson = lessonRepository.findById(id);
        // Converter a entidade para DTO
        return lesson.map(lessonMapper::toLessonDTO);
    }

    public Iterable<LessonDTO> getAllLessons() {
        // Buscar todas as entidades
        Iterable<LessonEntity> lessons = lessonRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(lessons.spliterator(), false)
                .map(lessonMapper::toLessonDTO)
                .collect(Collectors.toList());
    }

    public void updateLesson(LessonDTO lessonDTO) {
        // Converter DTO para entidade
        LessonEntity lesson = lessonMapper.toLesson(lessonDTO);
        // Atualizar a entidade
        lessonRepository.save(lesson);
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}
