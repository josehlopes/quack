package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.adapter.mapper.LessonMapper;
import com.thigas.quack.adapter.mapper.StepMapper;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.StepEntity;
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
    private final LessonMapper lessonMapper = LessonMapper.INSTANCE;
    @Autowired
    private IStepRepository stepRepository;
    @Autowired
    private ILessonRepository lessonRepository;

    @Transactional
    public StepDTO create(StepDTO stepDTO) {
        // Converter DTO para entidade
        StepEntity stepEntity = stepMapper.DtoToEntity(stepDTO);

        // Criar um conjunto para armazenar as lições
        Set<LessonEntity> lessonEntities = new HashSet<>();

        // Iterar sobre todos os IDs de lições
        for (Integer lessonId : stepDTO.getLessonIds()) {
            Optional<LessonEntity> lesson = lessonRepository.findById(lessonId);
            lesson.ifPresent(lessonEntities::add); // Adiciona a lição ao conjunto se estiver presente
        }

        // Definir as lições na entidade
        stepEntity.setLessons(lessonEntities);

        // Persistir a entidade
        StepEntity savedStep = stepRepository.save(stepEntity);

        // Converter a entidade salva de volta para DTO
        return stepMapper.EntityToDto(savedStep);
    }

    public Optional<StepDTO> getById(int id) {
        // Buscar a entidade do repositório
        Optional<StepEntity> step = stepRepository.findById(id);
        // Converter a entidade para DTO
        return step.map(stepMapper::EntityToDto);
    }

    public Iterable<StepDTO> getAll() {
        // Buscar todas as entidades
        Iterable<StepEntity> steps = stepRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(steps.spliterator(), false)
                .map(stepMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public void update(StepDTO stepDTO) {
        // Converter DTO para entidade
        StepEntity step = stepMapper.DtoToEntity(stepDTO);
        // Atualizar a entidade
        stepRepository.save(step);
    }

    public void delete(int id) {
        stepRepository.deleteById(id);
    }
}