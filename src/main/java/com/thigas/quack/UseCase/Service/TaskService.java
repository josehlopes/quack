package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Dto.StepDTO;
import com.thigas.quack.Adapter.Dto.TaskDTO;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.Infrastructure.Entity.TaskDataMapper;
import com.thigas.quack.UseCase.Gateway.StepDsGateway;
import com.thigas.quack.UseCase.Gateway.TaskDsGateway;
import com.thigas.quack.Infrastructure.Entity.StepDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {

    @Autowired
    private TaskDsGateway taskRepository;

    @Autowired
    private StepDsGateway stepRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    public void create(TaskDTO taskDTO) {
        TaskDataMapper taskDataMapper = objectMapperService.toModel(taskDTO);
        Set<StepDataMapper> stepEntities = new HashSet<>();

        for (StepDTO stepDTO : taskDTO.getSteps()) {
            stepRepository.findById(stepDTO.getId()).ifPresent(stepEntities::add);
        }

        taskDataMapper.setSteps(stepEntities);
        taskRepository.save(taskDataMapper);
    }

    public Optional<TaskDTO> getById(int id) {
        return taskRepository.findById(id)
                .map(objectMapperService::toDto);
    }

    public Iterable<TaskDTO> getAll() {
        Iterable<TaskDataMapper> tasks = taskRepository.findAll();
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toSet());
    }

    public void update(TaskDTO taskDTO) {
        TaskDataMapper taskDataMapper = objectMapperService.toModel(taskDTO);
        taskRepository.save(taskDataMapper);
    }

    public void delete(int id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task não encontrada com id: " + id);
        }
        taskRepository.deleteById(id);
    }
}
