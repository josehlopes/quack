package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Dto.LessonDTO;
import com.thigas.quack.Adapter.Dto.StepDTO;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.Infrastructure.Entity.StepDataMapper;
import com.thigas.quack.UseCase.Gateway.StepDsGateway;
import com.thigas.quack.Infrastructure.Entity.LessonDataMapper;
import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
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
    private StepDsGateway stepRepository;

    @Autowired
    private LessonDsGateway lessonRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    public void create(StepDTO stepDTO) {
        StepDataMapper stepDataMapper = objectMapperService.toModel(stepDTO);
        stepRepository.save(stepDataMapper);
    }

    public Optional<StepDTO> getById(int id) {
        return stepRepository.findById(id)
                .map(objectMapperService::toDto);
    }

    public Iterable<StepDTO> getAll() {
        Iterable<StepDataMapper> steps = stepRepository.findAll();
        return StreamSupport.stream(steps.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(StepDTO stepDTO) {
        StepDataMapper stepDataMapper = objectMapperService.toModel(stepDTO);
        stepRepository.save(stepDataMapper);
    }

    public void delete(int id) {
        stepRepository.deleteById(id);
    }

    public void updateStatus(Integer id, int statusValue) {
        Optional<StepDataMapper> optionalStep = stepRepository.findById(id);
        if (optionalStep.isPresent()) {
            StepDataMapper step = optionalStep.get();
            Status status = Status.fromValue(statusValue);
            step.setStatus(status);
            stepRepository.save(step);
        } else {
            throw new IllegalArgumentException("Step não encontrado com id: " + id);
        }
    }

    public Set<LessonDataMapper> verifyLessons(StepDTO stepDto) {
        Set<LessonDataMapper> lessonSet = new HashSet<>();

        if (stepDto.getLessons() == null || stepDto.getLessons().isEmpty()) {
            return lessonSet;
        }

        for (LessonDTO lessonDto : stepDto.getLessons()) {
            LessonDataMapper lesson = lessonRepository.findById(lessonDto.getId())
                    .orElseThrow(() -> new RuntimeException("Lição não encontrada com ID: " + lessonDto.getId()));
            lessonSet.add(lesson);
        }
        return lessonSet;
    }

    public void addLesson(StepDataMapper step, Set<LessonDataMapper> lessons) {
        step.getLessons().addAll(lessons);
        for (LessonDataMapper lesson : lessons) {
            lesson.getSteps().add(step);
        }
    }

    public void removeLesson(StepDataMapper step, LessonDataMapper lesson) {
        step.getLessons().remove(lesson);
        lesson.getSteps().remove(step);
    }
}
