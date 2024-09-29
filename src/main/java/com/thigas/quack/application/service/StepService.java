package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.adapter.mapper.LessonMapper;
import com.thigas.quack.adapter.mapper.StatisticsMapper;
import com.thigas.quack.adapter.mapper.StepMapper;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.domain.repository.ILessonRepository;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.domain.repository.ITaskRepository;
import com.thigas.quack.domain.repository.IStepRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;

import java.util.*;
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
        StepEntity stepEntity = stepMapper.dtoToEntity(stepDTO, context);
        List<LessonEntity> lessonEntities = new ArrayList<>();
        List<RoadmapEntity> roadmapEntities = new ArrayList<>();
        List<TaskEntity> taskEntities = new ArrayList<>();

        for (Integer lessonId : stepDTO.getLessons()) {
            Optional<LessonEntity> lesson = lessonRepository.findById(lessonId);
            if (lesson.isPresent()) {
                lessonEntities.add(lesson.get());
            } else {
                throw new IllegalArgumentException("Lesson não encontrada com id: " + lessonId);
            }
        }

        for (Integer roadmapId : stepDTO.getRoadmaps()) {
            Optional<RoadmapEntity> roadmap = roadmapRepository.findById(roadmapId);
            if (roadmap.isPresent()) {
                roadmapEntities.add(roadmap.get());
            } else {
                throw new IllegalArgumentException("Roadmap não encontrado com id: " + roadmapId);
            }
        }

        // Verificação e adição de tarefas
        for (Integer taskId : stepDTO.getTasks()) {
            Optional<TaskEntity> task = taskRepository.findById(taskId);
            if (task.isPresent()) {
                taskEntities.add(task.get());
            } else {
                throw new IllegalArgumentException("Task não encontrada com id: " + taskId);
            }
        }

        stepEntity.setLessons(new ArrayList<>());
        stepEntity.setRoadmaps(new ArrayList<>());
        stepEntity.setTasks(new ArrayList<>());

        stepEntity.setLessons(lessonEntities);
        stepEntity.setRoadmaps(roadmapEntities);
        stepEntity.setTasks(taskEntities);

        StepEntity savedStep = stepRepository.save(stepEntity);

        return stepMapper.entityToDto(savedStep, context);
    }

    public Optional<StepDTO> getById(int id) {
        Optional<StepEntity> stepOpt = stepRepository.findById(id);
        return stepOpt.map(step -> stepMapper.entityToDto(step, new CycleAvoidingMappingContext()));
    }


    public Iterable<StepDTO> getAll() {
        Iterable<StepEntity> steps = stepRepository.findAll();
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        return StreamSupport.stream(steps.spliterator(), false)
                .map(step -> stepMapper.entityToDto(step, context))
                .collect(Collectors.toList());
    }

    public void update(StepDTO stepDTO) {
        StepEntity step = stepMapper.dtoToEntity(stepDTO, context);
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