package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.adapter.mapper.LessonMapper;
import com.thigas.quack.adapter.mapper.StepMapper;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.domain.repository.ILessonRepository;
import com.thigas.quack.domain.repository.IStepRepository;
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

    private final StepMapper stepMapper = StepMapper.INSTANCE;
    @Autowired
    private IStepRepository stepRepository;
    @Autowired
    private ILessonRepository lessonRepository;

    @Transactional
    public StepDTO create(StepDTO stepDTO) {
        StepEntity stepEntity = stepMapper.dtoToEntity(stepDTO);
        Set<LessonEntity> lessonEntities = new HashSet<>();

        for (Integer lessonId : stepDTO.getLessonIds()) {
            Optional<LessonEntity> lesson = lessonRepository.findById(lessonId);
            if (lesson.isPresent()) {
                lessonEntities.add(lesson.get());
            } else {
                // Lide com o caso em que a lição não foi encontrada
                throw new IllegalArgumentException("Lesson não encontrada com id: " + lessonId);
            }
        }

        stepEntity.setLessons(lessonEntities);
        StepEntity savedStep = stepRepository.save(stepEntity);
        return stepMapper.entityToDto(savedStep);
    }

    public Optional<StepDTO> getById(int id) {
        Optional<StepEntity> step = stepRepository.findById(id);
        return step.map(stepMapper::entityToDto);
    }

    public Iterable<StepDTO> getAll() {
        Iterable<StepEntity> steps = stepRepository.findAll();
        return StreamSupport.stream(steps.spliterator(), false).map(stepMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public void update(StepDTO stepDTO) {
        StepEntity step = stepMapper.dtoToEntity(stepDTO);
        stepRepository.save(step);
    }

    public void delete(int id) {
        stepRepository.deleteById(id);
    }

    public void updateStatus(Integer id, int statusValue) {
        Optional<StepEntity> optionalStep = stepRepository.findById(id);
        if (optionalStep.isPresent()) {
            StepEntity step = optionalStep.get();
            Status status = Status.fromValue(statusValue); // converte o valor do status para o enum Status
            step.setStatus(status); // Certifique-se de ter um método setStatus na sua entidade
            stepRepository.save(step); // Salva a entidade atualizada
        } else {
            throw new IllegalArgumentException("Step não encontrado com id: " + id);
        }
    }
}