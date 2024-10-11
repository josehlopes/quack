package com.thigas.quack.adapter.mapper.utils;

import com.thigas.quack.adapter.model.BaseEntity;
import com.thigas.quack.adapter.model.BaseModel;
import com.thigas.quack.domain.model.Status;
import org.mapstruct.Context;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;


@Component
public class MapperUtils {

    @Named("entitiesToIntegers")
    public static <T extends BaseEntity> Set<Integer> mapEntitiesToIntegers(Set<T> entities) {
        return (entities == null) ? null : entities.stream()
                .map(BaseEntity::getId)
                .collect(Collectors.toSet());
    }

    @Named("integersToEntities")
    public static <T extends BaseEntity> Set<T> mapIntegersToEntities(Set<Integer> ids, Class<T> clazz, CycleAvoidingMappingContext context) {
        return (ids == null) ? null : ids.stream()
                .map(id -> {
                    try {
                        T entity = clazz.getDeclaredConstructor().newInstance();
                        entity.setId(id);
                        return entity;
                    } catch (Exception e) {
                        throw new RuntimeException("Error instantiating entity", e);
                    }
                }).collect(Collectors.toSet());
    }

    @Named("modelsToIntegers")
    public static <T extends BaseModel> Set<Integer> mapModelsToIntegers(Set<T> models) {
        return (models == null) ? null : models.stream()
                .map(BaseModel::getId)
                .collect(Collectors.toSet());
    }

    @Named("integersToModels")
    public static <T extends BaseModel> Set<T> mapIntegersToModels(Set<Integer> ids, Class<T> clazz, @Context CycleAvoidingMappingContext context) {
        return (ids == null) ? null : ids.stream().map(id -> mapIntegerToModel(id, clazz, context)).collect(Collectors.toSet());
    }

    @Named("integerToEntity")
    public static <T extends BaseEntity> T mapIntegerToEntity(Integer id, Class<T> clazz, @Context CycleAvoidingMappingContext context) {
        if (id == null) {
            return null;
        }
        try {
            T entity = context.getMappedInstance(id, clazz);
            if (entity == null) {
                entity = clazz.getDeclaredConstructor().newInstance();
                entity.setId(id);
                context.storeMappedInstance(id, entity);
            }
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Error instantiating entity", e);
        }
    }

    @Named("entityToInteger")
    public static <T extends BaseEntity> Integer mapEntityToInteger(T entity) {
        return (entity == null) ? null : entity.getId();
    }

    @Named("integerToModel")
    public static <T extends BaseModel> T mapIntegerToModel(Integer id, Class<T> clazz, @Context CycleAvoidingMappingContext context) {
        if (id == null) {
            return null;
        }
        try {
            T model = context.getMappedInstance(id, clazz);
            if (model == null) {
                model = clazz.getDeclaredConstructor().newInstance();
                model.setId(id);
                context.storeMappedInstance(id, model);
            }
            return model;
        } catch (Exception e) {
            throw new RuntimeException("Error instantiating model", e);
        }
    }

    @Named("modelToInteger")
    public static <T extends BaseModel> Integer modelToInteger(T model) {
        return (model == null) ? null : model.getId();
    }


    @Named("statusToInt")
    public static int statusToInt(Status status) {
        return status != null ? status.getValue() : 0;
    }

    @Named("intToStatus")
    public static Status intToStatus(int value) {
        return Status.fromValue(value);
    }
}