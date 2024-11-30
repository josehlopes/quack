package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.StepDataMapper;
import com.thigas.quack.Domain.Entity.Interface.Step;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperDefaults {

    default String map(OffsetDateTime value) {
        return value != null ? value.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME) : null;
    }

    default OffsetDateTime map(String value) {
        return value != null ? OffsetDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME) : null;
    }

    @Named("idsToItemSet")
    default Set<Step> idsToItemSet(Set<Integer> ids, Set<Step> allSteps) {
        return ids.stream()
                .map(id -> allSteps.stream()
                        .filter(step -> step.getId() == id)
                        .findFirst()
                        .orElse(null))
                .collect(Collectors.toSet());
    }

    @Named("mapStepsToIds")
    default Set<Integer> mapStepsToIds(Set<Step> steps) {
        if (steps == null) {
            return null;
        }
        return steps.stream()
                .map(Step::getId)
                .collect(Collectors.toSet());
    }

    @Named("mapStepDataMapperToIds")
    default Set<Integer> mapStepDataMapperToIds(Set<StepDataMapper> stepsData) {
        if (stepsData == null) {
            return null;
        }
        return stepsData.stream()
                .map(StepDataMapper::getId)  // Supondo que StepDataMapper tenha um método getId()
                .collect(Collectors.toSet());
    }
}

