package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.adapter.mapper.StepMapper;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.domain.repository.ILessonRepository;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.domain.repository.IStepRepository;
import com.thigas.quack.domain.repository.ITaskRepository;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StepService {


    @Autowired
    private IStepRepository stepRepository;

    @Autowired
    private ILessonRepository lessonRepository;

    @Autowired
    private ITaskRepository taskRepository;

    @Autowired
    private IRoadmapRepository roadmapRepository;

    @Autowired
    private StepMapper stepMapper;

    @Autowired
    private CycleAvoidingMappingContext context;


    // TODO: Ver se da para melhorar a lógica de criação do Step
    // TODO: Criar método que crie um Step com uma UNIDADE de cada item ao invés de uma Lista

    public StepDTO create(StepDTO stepDTO) {
        StepModel stepModel = stepMapper.dtoToModel(stepDTO, context);
        StepModel savedStep = stepRepository.save(stepModel);
        return stepMapper.modelToDto(savedStep, context);
    }

    public Optional<StepDTO> getById(int id) {
        Optional<StepModel> stepOptional = stepRepository.findById(id);
        return stepOptional.map(step -> stepMapper.modelToDto(step, new CycleAvoidingMappingContext()));
    }


    public Iterable<StepDTO> getAll() {
        Iterable<StepModel> steps = stepRepository.findAll();
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        return StreamSupport.stream(steps.spliterator(), false)
                .map(step -> stepMapper.modelToDto(step, context))
                .collect(Collectors.toList());
    }

    public void update(StepDTO stepDTO) {
        StepModel step = stepMapper.dtoToModel(stepDTO, context);
        stepRepository.save(step);
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
}