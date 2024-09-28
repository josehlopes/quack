package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(source = "steps", target = "steps", ignore = true)
    TaskDTO entityToDto(TaskEntity taskEntity);

    @Mapping(source = "steps", target = "steps", ignore = true)
    TaskEntity dtoToEntity(TaskDTO taskDTO);

    @Mapping(source = "steps", target = "steps", ignore = true)
    TaskModel entityToModel(TaskEntity taskEntity);

    @Mapping(source = "steps", target = "steps", ignore = true)
    TaskEntity modelToEntity(TaskModel taskModel);

    // Mapeia um conjunto de StepEntity para um conjunto de Integer (IDs)
    // default Set<Integer> stepsToIds(Set<StepEntity> steps) {
    // if (steps == null) {
    // return null;
    // }
    // return steps.stream().map(StepEntity::getId).collect(Collectors.toSet());
    // }

    // // Mapeia um conjunto de Integer (IDs) para um conjunto de StepEntity
    // default Set<StepEntity> idsToSteps(Set<Integer> steps) {
    // if (steps == null) {
    // return null;
    // }
    // return steps.stream().map(id -> {
    // StepEntity step = new StepEntity();
    // step.setId(id);
    // return step;
    // }).collect(Collectors.toSet());
    // }
}
