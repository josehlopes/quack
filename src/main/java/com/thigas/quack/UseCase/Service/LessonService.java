package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Dto.LessonDTO;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.Infrastructure.Model.LessonDataMapper;
import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LessonService {

    @Autowired
    private LessonDsGateway lessonRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    public void create(LessonDTO lessonDTO) {
        LessonDataMapper lessonDataMapper = objectMapperService.toModel(lessonDTO);
        lessonRepository.save(lessonDataMapper);
    }

    public Set<LessonDTO> createAll(Set<LessonDTO> lessonDTOs) {
        if (lessonDTOs == null || lessonDTOs.isEmpty()) {
            throw new IllegalArgumentException("LessonDTOs list cannot be null or empty");
        }

        Set<LessonDataMapper> lessonEntities = lessonDTOs.stream()
                .map(objectMapperService::toModel)
                .collect(Collectors.toSet());

        Set<LessonDataMapper> savedLessons;
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
        Optional<LessonDataMapper> lessonOpt = lessonRepository.findById(id);
        return lessonOpt.map(objectMapperService::toDto);
    }

    public Iterable<LessonDTO> getAll() {
        Iterable<LessonDataMapper> lessons = lessonRepository.findAll();
        return StreamSupport.stream(lessons.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(LessonDTO lessonDTO) {
        LessonDataMapper lesson = objectMapperService.toModel(lessonDTO);
        lessonRepository.save(lesson);
    }

    public void deleteLesson(int id) {
        lessonRepository.deleteById(id);
    }
}
