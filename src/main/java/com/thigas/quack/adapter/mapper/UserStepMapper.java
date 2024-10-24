package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserStepDTO;
import com.thigas.quack.adapter.mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.domain.entity.UserStepEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserStepModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {DefaultMapper.class})
public interface UserStepMapper {
    @Mappings({
            @Mapping(source = "user.id", target = "user"),
            @Mapping(source = "step.id", target = "step"),
            @Mapping(target = "status", qualifiedByName = "statusValueToInteger")
    })
    UserStepDTO entityToDto(UserStepEntity userStepEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "user", target = "user.id"),
            @Mapping(source = "step", target = "step.id"),
            @Mapping(target = "status", qualifiedByName = "integerToStatusValue")
    })
    UserStepEntity dtoToEntity(UserStepDTO userStepDTO, @Context CycleAvoidingMappingContext context);

    UserStepModel entityToModel(UserStepEntity userStepEntity, @Context CycleAvoidingMappingContext context);

    UserStepEntity modelToEntity(UserStepModel userStepModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "step", target = "step.id"),
            @Mapping(target = "status", qualifiedByName = "integerToStatusValue")})
    UserStepModel dtoToModel(UserStepDTO userStepDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "user.id", target = "user"),
            @Mapping(source = "step.id", target = "step"),
            @Mapping(target = "status", qualifiedByName = "statusValueToInteger")
    })
    UserStepDTO modelToDto(UserStepModel userStepModel, @Context CycleAvoidingMappingContext context);
}