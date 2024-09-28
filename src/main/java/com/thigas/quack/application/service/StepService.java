package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.adapter.mapper.LessonMapper;
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

    @Autowired
    private ITaskRepository taskRepository;

    @Autowired
    private IRoadmapRepository roadmapRepository;

    // TODO: Ver se da para melhorar a lógica de criação do Step
    // TODO: Criar método que crie um Step com uma UNIDADE de cada item ao invés de
    // uma Lista
    public StepDTO create(StepDTO stepDTO) {
        StepEntity stepEntity = stepMapper.dtoToEntity(stepDTO);
        Set<LessonEntity> lessonEntities = new HashSet<>();
        Set<RoadmapEntity> roadmapEntities = new HashSet<>();
        Set<TaskEntity> taskEntities = new HashSet<>();

        for (Integer lessonId : stepDTO.getLessons()) {
            Optional<LessonEntity> lesson = lessonRepository.findById(lessonId);
            if (lesson.isPresent()) {
                lessonEntities.add(lesson.get());
            } else {
                throw new IllegalArgumentException("Lesson não encontrada com id: " + lessonId);
            }
        }

        // Verificação e adição de roadmaps
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

        // Atribuindo as entidades ao StepEntity
        stepEntity.setLessons(lessonEntities);
        stepEntity.setRoadmaps(roadmapEntities);
        stepEntity.setTasks(taskEntities);

        // Salva o StepEntity no banco de dados
        StepEntity savedStep = stepRepository.save(stepEntity);

        // Verifique se o ID foi atribuído
        if (savedStep.getId() <= 0) {
            throw new IllegalStateException("Failed to create step with valid ID.");
        }

        // Retorne o StepDTO convertido a partir do StepEntity salvo
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