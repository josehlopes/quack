package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface StepMapper {

    StepMapper INSTANCE = Mappers.getMapper(StepMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "step", target = "steps")
    StepModel toStepModel(StepEntity stepEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "steps", target = "step")
    StepEntity toStep(StepModel stepModel);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "steps", target = "steps")
    StepDTO toStepDTO(StepEntity stepEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "steps", target = "steps")
    StepEntity toStep(StepDTO stepDTO);

    default Set<StepModel> mapIdsToStepModels(Set<Integer> stepIds) {
        if (stepIds == null) {
            return null;
        }
        return stepIds.stream()
                .map(id -> {
                    StepModel stepModel = new StepModel();
                    stepModel.setId(id);
                    return stepModel;
                })
                .collect(Collectors.toSet());
    }


    default Set<Integer> mapStepsToIds(Set<StepEntity> steps) {
        if (steps == null) {
            return null;
        }
        return steps.stream()
                .map(StepEntity::getId)
                .collect(Collectors.toSet());
    }


    default Set<StepEntity> mapIdsToSteps(Set<Integer> stepIds) {
        if (stepIds == null) {
            return null;
        }
        return stepIds.stream()
                .map(id -> {
                    StepEntity step = new StepEntity();
                    step.setId(id);
                    return step;
                })
                .collect(Collectors.toSet());
    }
}
