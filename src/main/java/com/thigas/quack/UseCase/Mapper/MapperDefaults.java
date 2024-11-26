package com.thigas.quack.UseCase.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperDefaults {

    default String map(OffsetDateTime value) {
        return value != null ? value.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME) : null;
    }

    default OffsetDateTime map(String value) {
        return value != null ? OffsetDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME) : null;
    }
}
