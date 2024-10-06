package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.domain.repository.ILessonRepository;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.domain.repository.ITaskRepository;
import com.thigas.quack.domain.repository.IStepRepository;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StepService {

    // TODO: Melhorar a lógica de criação do Step
    // TODO: Criar método que crie um Step com uma UNIDADE de cada item ao invés de uma Lista

    @Autowired
    private IStepRepository stepRepository;

    @Autowired
    private ILessonRepository lessonRepository;

    @Autowired
    private ITaskRepository taskRepository;

    @Autowired
    private IRoadmapRepository roadmapRepository;

    @Autowired
    private ObjectMapperService objectMapperService;

    public StepDTO create(StepDTO stepDTO) {
        StepModel stepModel = objectMapperService.toModel(stepDTO);
        StepModel savedStep = stepRepository.save(stepModel);
        return objectMapperService.toDto(savedStep);
    }

    public Optional<StepDTO> getById(int id) {
        return stepRepository.findById(id)
                .map(objectMapperService::toDto);
    }

    public Iterable<StepDTO> getAll() {
        Iterable<StepModel> steps = stepRepository.findAll();
        return StreamSupport.stream(steps.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(StepDTO stepDTO) {
        StepModel stepModel = objectMapperService.toModel(stepDTO);
        stepRepository.save(stepModel);
    }

    public void delete(int id) {
        stepRepository.deleteById(id);
    }

    public void updateStatus(Integer id, int statusValue) {
        Optional<StepModel> optionalStep = stepRepository.findById(id);
        if (optionalStep.isPresent()) {
            StepModel step = optionalStep.get();
            Status status = Status.fromValue(statusValue);
            step.setStatus(status);
            stepRepository.save(step);
        } else {
            throw new IllegalArgumentException("Step não encontrado com id: " + id);
        }
    }

    public Set<LessonModel> verifyLessons(StepDTO stepDto) {
        Set<LessonModel> lessonSet = new HashSet<>();

        if (stepDto.getLessons() == null || stepDto.getLessons().isEmpty()) {
            return lessonSet;
        }

        for (Integer lessonId : stepDto.getLessons()) {
            LessonModel lesson = lessonRepository.findById(lessonId)
                    .orElseThrow(() -> new RuntimeException("Lição não encontrada com ID: " + lessonId));
            lessonSet.add(lesson);
        }
        return lessonSet;
    }

    public void addLesson(StepModel step, Set<LessonModel> lessons) {
        step.getLessons().addAll(lessons);
        for (LessonModel lesson : lessons) {
            lesson.getSteps().add(step);
        }
    }

    public void removeLesson(StepModel step, LessonModel lesson) {
        step.getLessons().remove(lesson);
        lesson.getSteps().remove(step);
    }
}
