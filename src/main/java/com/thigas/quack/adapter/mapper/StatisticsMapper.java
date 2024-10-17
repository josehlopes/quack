package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.adapter.mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.domain.entity.StatisticsEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DefaultMapper.class})
public interface StatisticsMapper {

    @Mapping(source = "user.id", target = "user")
    StatisticsDTO entityToDto(StatisticsEntity statistics, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "user", target = "user.id")
    StatisticsEntity dtoToEntity(StatisticsDTO statisticsDTO, @Context CycleAvoidingMappingContext context);

    StatisticsModel entityToModel(StatisticsEntity statistics, @Context CycleAvoidingMappingContext context);

    StatisticsEntity modelToEntity(StatisticsModel statisticsModel, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "user", target = "user.id")
    StatisticsModel dtoToModel(StatisticsDTO statisticsDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "user.id", target = "user")
    StatisticsDTO modelToDto(StatisticsModel statisticsModel, @Context CycleAvoidingMappingContext context);

    default Status map(int value) {
        return Status.fromValue(value);
    }

    default int map(Status status) {
        return status.getValue();
    }
}
