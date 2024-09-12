package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.adapter.mapper.StepMapper;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.repository.IStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StepService {

    @Autowired
    private IStepRepository stepRepository;

    private final StepMapper stepMapper = StepMapper.INSTANCE;

    public StepDTO create(StepDTO stepDTO) {
        // Converter DTO para entidade
        StepEntity step = stepMapper.toStep(stepDTO);
        // Salvar a entidade
        StepEntity savedStep = stepRepository.save(step);
        // Converter entidade de volta para DTO
        return stepMapper.toStepDTO(savedStep);
    }

    public Optional<StepDTO> getById(int id) {
        // Buscar a entidade do repositório
        Optional<StepEntity> step = stepRepository.findById(id);
        // Converter a entidade para DTO
        return step.map(stepMapper::toStepDTO);
    }

    public Iterable<StepDTO> getAll() {
        // Buscar todas as entidades
        Iterable<StepEntity> steps = stepRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(steps.spliterator(), false)
                .map(stepMapper::toStepDTO)
                .collect(Collectors.toList());
    }

    public void update(StepDTO stepDTO) {
        // Converter DTO para entidade
        StepEntity step = stepMapper.toStep(stepDTO);
        // Atualizar a entidade
        stepRepository.save(step);
    }

    public void deleteStep(int id) {
        stepRepository.deleteById(id);
    }
}
